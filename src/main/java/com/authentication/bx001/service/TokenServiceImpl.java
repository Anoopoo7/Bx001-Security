package com.authentication.bx001.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.bx001.core.Constants;
import com.authentication.bx001.core.enums.TokenEnums;
import com.authentication.bx001.core.enums.TokenTypes;
import com.authentication.bx001.helper.TokenHelper;
import com.authentication.bx001.model.CreateTokenRequest;
import com.authentication.bx001.model.TokenResponse;
import com.authentication.bx001.rest.UserRestUtil;
import com.authentication.bx001.utils.JwtUtils;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserRestUtil userRestUtil;
    @Autowired
    private JwtUtils jwtUtils;

    private TokenResponse populateToken(Map<String, String> user) {
        String accessToken = jwtUtils.generateToken(user, TokenTypes.access.name());
        String refreshToken = jwtUtils.generateToken(user, TokenTypes.refresh.name());
        return new TokenResponse(
                accessToken,
                refreshToken,
                user.get(Constants.permissions.name()));
    }

    @Override
    public TokenResponse createToken(final CreateTokenRequest createTokenRequest,
            final HttpServletRequest request) {
        if (StringUtils.isNotBlank(createTokenRequest.getTokenType().name())
                && TokenTypes.Anonymus.equals(createTokenRequest.getTokenType())) {
            Map<String, String> user = userRestUtil.createAnonymusUser();
            if (null != user) {
                return populateToken(user);
            }
            throw new RuntimeException(TokenEnums.NO_ANONYMUS_ACCESS.name());
        }
        String token = TokenHelper.extractToken(request);
        if (StringUtils.isNotEmpty(token)) {
            if (jwtUtils.validateToken(token)) {
                Map<String, String> tokenData = jwtUtils.decriptToken(token);
                if (TokenTypes.access.name().equals(tokenData.get(Constants.tokenType.name()))) {
                    Map<String, String> user = userRestUtil.verifyUser(tokenData);
                    if (null != user) {
                        return populateToken(user);
                    }
                }
            }
        }
        throw new RuntimeException(TokenEnums.INVALID_TOKEN.name());
    }

    @Override
    public TokenResponse createRefreshToken(final HttpServletRequest request) {
        String token = TokenHelper.extractToken(request);
        if (StringUtils.isNotEmpty(token)) {
            if (jwtUtils.validateToken(token)) {
                Map<String, String> tokenData = jwtUtils.decriptToken(token);
                if (TokenTypes.refresh.name().equals(tokenData.get(Constants.tokenType.name()))) {
                    Map<String, String> user = userRestUtil.verifyUser(tokenData);
                    if (null != user) {
                        return populateToken(user);
                    }
                }
            }
        }
        throw new RuntimeException(TokenEnums.INVALID_TOKEN.name());
    }

}
