package com.sodamdadam.server.global.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class ValidationException extends RuntimeException{

    private Map<String, String> errorMap;

    public ValidationException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }

}
