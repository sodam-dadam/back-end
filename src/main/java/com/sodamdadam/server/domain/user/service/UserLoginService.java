package com.sodamdadam.server.domain.user.service;

import com.sodamdadam.server.domain.user.dto.request.UserLoginRequest;
import com.sodamdadam.server.domain.user.dto.response.UserLoginResponse;
import com.sodamdadam.server.domain.user.entity.User;
import com.sodamdadam.server.domain.user.repository.UserRepository;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import com.sodamdadam.server.global.error.ErrorCode;
import com.sodamdadam.server.global.exception.SodamDadamException;
import com.sodamdadam.server.global.jwt.JwtProperties;
import com.sodamdadam.server.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserLoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<CommonResponse> loginUser(UserLoginRequest request) {


        User findUser = userRepository.findById(request.getId())
                .orElseThrow(() -> new SodamDadamException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(request.getPassword(), findUser.getPassword())) {
            throw new SodamDadamException(ErrorCode.USER_NOT_FOUND);
        }

        String accessToken = jwtTokenProvider.createAccessToken(request.getId());
        String refreshToken = jwtTokenProvider.createRefreshToken(request.getId());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("UserLogin Success")
                        .data(new UserLoginResponse(JwtProperties.TOKEN_PREFIX + accessToken,
                                JwtProperties.TOKEN_PREFIX + refreshToken))
                        .build());

    }
}
