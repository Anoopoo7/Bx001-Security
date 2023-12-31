package com.authentication.bx001.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.authentication.bx001.core.Constants;
import com.authentication.bx001.core.enums.TokenTypes;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    @Value("${custom.token.fields}")
    private List<String> tokenFields;

    @Value("${custom.token.secret")
    private String SECRET_KEY;

    @Value("${custom.token.refreshIntervel")
    private String refreshIntervel;

    @Value("${custom.token.acessIntervel")
    private String acessIntervel;

    private Date expire(String type) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,
                type.equals(TokenTypes.access.name()) ? 10 : 60);
        return calendar.getTime();
    }

    public String generateToken(Map<String, String> userView, String tokenType) {
        JwtBuilder builder = Jwts.builder().setIssuedAt(new Date());
        if (null != tokenFields) {
            tokenFields.stream().forEach(field -> {
                builder.claim(field, userView.get(field));
            });
        }
        builder.claim(Constants.tokenType.name(), tokenType);
        builder.setExpiration(expire(tokenType));
        return builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public boolean validateToken(String token) {
        try {
            Claims decriptedData = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return !decriptedData.getExpiration().before(new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            return false;
        }
    }

    public Map<String, String> decriptToken(String token) {
        Jws<Claims> decriptedData = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        Claims claims = decriptedData.getBody();
        Map<String, String> tokenData = new HashMap<String, String>();
        if (null != tokenFields) {
            tokenFields.stream().forEach(field -> {
                tokenData.put(field, (String) claims.get(field));
            });
        }
        tokenData.put(Constants.tokenType.name(),
                (String) claims.get(Constants.tokenType.name()));
        return tokenData;
    }
}
