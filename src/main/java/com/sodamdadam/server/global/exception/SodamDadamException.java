package com.sodamdadam.server.global.exception;

import com.sodamdadam.server.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SodamDadamException extends RuntimeException{
    private final ErrorCode errorCode;
}
