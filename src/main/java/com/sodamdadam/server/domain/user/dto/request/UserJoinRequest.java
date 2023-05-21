package com.sodamdadam.server.domain.user.dto.request;

import com.sodamdadam.server.domain.user.enums.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJoinRequest {

    private String id;
    private String password;
    private String name;
    private String birthDate;
    private Gender gender;
    private String email;
    private String phone;

    @Builder
    public UserJoinRequest(String id, String password, String name, String birthDate, Gender gender,
                           String email, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }
}
