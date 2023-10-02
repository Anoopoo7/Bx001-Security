package com.authentication.bx001.model;

import javax.validation.constraints.NotBlank;

import com.authentication.bx001.core.enums.TokenTypes;
import com.authentication.bx001.core.enums.UserErrors;

import lombok.Data;

@Data
public class CreateTokenRequest {

    @NotBlank(message = UserErrors.InvalidEmail)
    private String email;

    @NotBlank(message = UserErrors.InvalidPassword)
    private String password;

    private TokenTypes tokenType;
}
