package com.authentication.bx001.service;

import java.util.Map;

import com.authentication.bx001.model.CreateTokenRequest;
import com.authentication.bx001.model.TokenResponse;

import jakarta.servlet.http.HttpServletRequest;

public interface TokenService {

    /**
     * Create token
     * 
     * @param createTokenRequest
     * @param request
     * @return
     */
    TokenResponse createToken(final CreateTokenRequest createTokenRequest, final HttpServletRequest request);

    /**
     * Create token from refresh token
     * 
     * @param request
     * @return
     */
    TokenResponse createRefreshToken(final HttpServletRequest request);

    /**
     * Validate token
     * 
     * @param request
     * @return
     */
    Map<String, String> validateToken(final HttpServletRequest request);

}
