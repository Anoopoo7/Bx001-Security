package com.authentication.bx001.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.bx001.model.CreateTokenRequest;
import com.authentication.bx001.model.TokenResponse;
import com.authentication.bx001.service.TokenService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/token")
public class TokenControllerV1 {

    @Autowired
    private TokenService tokenService;

    /**
     * Create token
     * 
     * @param createTokenRequest
     * @param request
     * @return
     */
    @PostMapping
    public TokenResponse createToken(final @Valid @RequestBody CreateTokenRequest createTokenRequest,
            final HttpServletRequest request) {
        return tokenService.createToken(createTokenRequest, request);
    }
}
