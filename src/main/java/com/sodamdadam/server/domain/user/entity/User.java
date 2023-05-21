package com.sodamdadam.server.domain.user.entity;

import com.sodamdadam.server.domain.user.enums.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String id;

    private String password;

    private String name;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String email;

    private String phone;

    @Builder
    public User(String id, String password, String name, Date birthDate, Gender gender, String email, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }
}