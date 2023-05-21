package com.sodamdadam.server.domain.user.entity;

import com.sodamdadam.server.domain.user.enums.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotEmpty
    private String id;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty(message = "생년월일 입력은 필수 입니다.")
    @Pattern(regexp = "((19|20)\\d{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])",
            message = "생년월일 형식에 맞지 않습니다.")
    private String birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotEmpty(message = "이메일 입력은 필수 입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @Pattern(regexp = "^01(?:0|1|[6-9])(\\d{3}|\\d{4})(\\d{4})$", message = "휴대폰 번호 형식에 맞지 않습니다.")
    private String phone;

    @Builder
    public User(String id, String password, String name, String birthDate, Gender gender, String email, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }
}