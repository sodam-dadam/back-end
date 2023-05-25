package com.sodamdadam.server.domain.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sodamdadam.server.domain.user.dto.request.UserJoinRequest;
import com.sodamdadam.server.domain.user.dto.request.UserLoginRequest;
import com.sodamdadam.server.domain.user.dto.response.UserLoginResponse;
import com.sodamdadam.server.domain.user.entity.User;
import com.sodamdadam.server.domain.user.enums.Gender;
import com.sodamdadam.server.domain.user.repository.UserRepository;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import com.sodamdadam.server.global.exception.SodamDadamException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserLoginServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    private ResponseEntity<CommonResponse> firstResponseEntity;
    private ResponseEntity<CommonResponse> secondResponseEntity;


    @Test
    @Transactional
    @DisplayName("로그인 성공")
    public void loginUser() {

        User user = User.builder()
                .id("asdf")
                .password(bCryptPasswordEncoder.encode("asdf"))
                .name("김현욱")
                .birthDate(new Date())
                .gender(Gender.MAN)
                .email("hyeonwook98@naver.com")
                .phone("010-2988-9330")
                .build();

        userRepository.save(user);

        UserLoginRequest loginDto = UserLoginRequest.builder()
                .id("asdf")
                .password("asdf")
                .build();

        ResponseEntity<CommonResponse> responseEntity = userLoginService.loginUser(loginDto);

        CommonResponse response = responseEntity.getBody();
        Object obj = response.getData();
        UserLoginResponse userLoginResponse = (UserLoginResponse) obj;
        String accessToken = userLoginResponse.getAccessToken();

        System.out.println(accessToken);
        Assertions.assertNotNull(accessToken);

    }

    @Test
    @Transactional
    @DisplayName("로그인 실패")
    public void loginUserWithError() {

        User user = User.builder()
                .id("asdf")
                .password(bCryptPasswordEncoder.encode("asdf"))
                .name("김현욱")
                .birthDate(new Date())
                .gender(Gender.MAN)
                .email("hyeonwook98@naver.com")
                .phone("010-2988-9330")
                .build();

        userRepository.save(user);

        UserLoginRequest firstLoginDto = UserLoginRequest.builder()
                .id("asdf1")
                .password("asdf")
                .build();

        UserLoginRequest secondLoginDto = UserLoginRequest.builder()
                .id("asdf")
                .password("asdf1")
                .build();

        Assertions.assertThrows(SodamDadamException.class, () -> {
            firstResponseEntity = userLoginService.loginUser(firstLoginDto);
        });

        Assertions.assertThrows(SodamDadamException.class, () -> {
            secondResponseEntity = userLoginService.loginUser(secondLoginDto);
        });

    }
}