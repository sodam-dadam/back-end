package com.sodamdadam.server.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // 400
    USER_NOT_FOUND(404, "User Not Found"),
    NOTICEPOST_NOT_FOUND(404,"Notice Post Not Found"),

    // 401
    INVALID_JWT(401, "Invalid Jwt"),
    EXPIRED_JWT(401, "Expired Jwt"),

    // 409
    ALREADY_ID_EXIST(409, "Already Id Exist");

    private final int status;
    private final String message;
}
