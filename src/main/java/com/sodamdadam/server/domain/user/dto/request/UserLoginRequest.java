package com.sodamdadam.server.domain.user.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginRequest {

    @NotEmpty
    private String id;
    @NotEmpty
    private String password;

    @Builder
    public UserLoginRequest(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
