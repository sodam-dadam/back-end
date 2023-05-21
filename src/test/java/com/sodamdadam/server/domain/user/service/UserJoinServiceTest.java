package com.sodamdadam.server.domain.user.service;

import com.sodamdadam.server.domain.user.dto.request.UserJoinRequest;
import com.sodamdadam.server.domain.user.entity.User;
import com.sodamdadam.server.domain.user.enums.Gender;
import com.sodamdadam.server.domain.user.repository.UserRepository;
import com.sodamdadam.server.global.exception.SodamDadamException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;


@SpringBootTest
class UserJoinServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserJoinService userJoinService;

    @Test
    @Transactional
    @DisplayName("회원가입성공")
    public void setUser() {

        UserJoinRequest userDto = UserJoinRequest.builder()
                .id("asdf")
                .password("asdf")
                .name("김현욱")
                .birthDate(new Date())
                .gender(Gender.MAN)
                .email("hyeonwook98@naver.com")
                .phone("010-2988-9330")
                .build();

        userJoinService.setUser(userDto);
        Optional<User> findUser = userRepository.findById("asdf");

        Assertions.assertEquals(userDto.getId(), findUser.get().getId());
    }

    @Test
    @Transactional
    @DisplayName("아이디 중복으로 인한 회원가입 실패")
    public void setUserWithError() {

        UserJoinRequest userDto = UserJoinRequest.builder()
                .id("asdf")
                .password("asdf")
                .name("김현욱")
                .birthDate(new Date())
                .gender(Gender.MAN)
                .email("hyeonwook98@naver.com")
                .phone("010-2988-9330")
                .build();

        userJoinService.setUser(userDto);

        Assertions.assertThrows(SodamDadamException.class, () -> {
            userJoinService.setUser(userDto);
        });
    }
}