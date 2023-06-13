package com.sodamdadam.server.domain.user.dto.response;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginResponse {

    private String accessToken;
    private String refreshToken;

    public UserLoginResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
