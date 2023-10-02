package com.authentication.bx001.controller;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.authentication.bx001.core.ExceptionResponse;

@ControllerAdvice
@Configuration
public class ExceptionHandlers {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception ex) {
        return new ResponseEntity<ExceptionResponse>(
                new ExceptionResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), List.of(ex.getMessage())),
                HttpStatus.BAD_REQUEST);
    }

}
