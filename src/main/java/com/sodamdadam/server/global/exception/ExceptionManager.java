package com.sodamdadam.server.global.exception;

import com.sodamdadam.server.global.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(SodamDadamException.class)
    public ResponseEntity<ErrorResponse> SodamDadamExceptionHandler(SodamDadamException e) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(e.getErrorCode().getStatus())
                        .message(e.getErrorCode().getMessage())
                        .build(),
                HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

}
