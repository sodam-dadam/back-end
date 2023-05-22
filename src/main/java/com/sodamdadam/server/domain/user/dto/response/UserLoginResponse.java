package com.sodamdadam.server.domain.user.dto.response;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginResponse {

    private String AccessToken;

    public UserLoginResponse(String accessToken) {
        AccessToken = accessToken;
    }
}
