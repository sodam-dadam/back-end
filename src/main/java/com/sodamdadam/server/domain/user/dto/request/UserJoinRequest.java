package com.sodamdadam.server.domain.user.dto.request;

import com.sodamdadam.server.domain.user.enums.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJoinRequest {

    @NotEmpty
    private String id;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @NotNull
    private Date birthDate;
    @NotNull
    private Gender gender;
    @NotEmpty(message = "이메일 입력은 필수 입니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;
    @Pattern(regexp = "^01(?:0|1|[6-9])-(\\d{3}|\\d{4})-(\\d{4})$", message = "휴대폰 번호 형식에 맞지 않습니다.")
    private String phone;

    @Builder
    public UserJoinRequest(String id, String password, String name, Date birthDate, Gender gender,
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
