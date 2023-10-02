package com.authentication.bx001.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
                type.equals("access") ? 10 : 60);
        return calendar.getTime();
    }

    public String generateToken(Map<String, String> userView, String tokenType) {
        JwtBuilder builder = Jwts.builder().setIssuedAt(new Date());
        if (null != tokenFields) {
            tokenFields.stream().forEach(field -> {
                builder.claim(field, userView.get(field));
            });
        }
        builder.claim("tokenType", tokenType);
        builder.setExpiration(expire(tokenType));
        return builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    // public boolean validateToken(String token) {
    // try {
    // Claims decriptedData =
    // Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    // return !decriptedData.getExpiration().before(new
    // Date(System.currentTimeMillis()));
    // } catch (Exception e) {
    // return false;
    // }
    // }

    // public TokenData decriptToken(String token) {
    // Jws<Claims> decriptedData =
    // Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
    // Claims claims = decriptedData.getBody();
    // String email = (String) claims.get("email");
    // String userId = (String) claims.get("userId");
    // boolean annonymus = (boolean) claims.get("annonymus");
    // String tokenType = (String) claims.get("tokenType");
    // TokenData tokenData = new TokenData(email, userId, annonymus, tokenType);
    // return tokenData;
    // }
}
