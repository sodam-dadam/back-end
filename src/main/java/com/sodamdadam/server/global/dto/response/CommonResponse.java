package com.sodamdadam.server.global.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommonResponse<T> {

    private final int status;
    private final String message;
    private T data;

}
