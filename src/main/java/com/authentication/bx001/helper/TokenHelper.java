package com.authentication.bx001.helper;

import jakarta.servlet.http.HttpServletRequest;

public class TokenHelper {

    /**
     * Extract token from request
     * 
     * @param request
     * @return
     */
    public static String extractToken(final HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }

}
