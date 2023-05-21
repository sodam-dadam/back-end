package com.sodamdadam.server.global.exception;

import com.sodamdadam.server.global.dto.response.CommonResponse;
import com.sodamdadam.server.global.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(SodamDadamException.class)
    public ResponseEntity<ErrorResponse> sodamDadamExceptionHandler(SodamDadamException e) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(e.getErrorCode().getStatus())
                        .message(e.getErrorCode().getMessage())
                        .build(),
                HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<CommonResponse> validationExceptionHandler(ValidationException e) {
        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(e.getMessage())
                        .data(e.getErrorMap())
                        .build()
                ,HttpStatus.BAD_REQUEST);
    }


}
