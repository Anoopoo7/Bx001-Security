package com.authentication.bx001.service;

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
    TokenResponse createToken(CreateTokenRequest createTokenRequest, HttpServletRequest request);

}
