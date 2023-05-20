package com.sodamdadam.server.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // 409
    ALREADY_ID_EXIST(409, "Already Id Exist");

    private final int status;
    private final String message;
}
