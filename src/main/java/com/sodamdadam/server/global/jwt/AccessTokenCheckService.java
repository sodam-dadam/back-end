package com.sodamdadam.server.global.jwt;

import com.sodamdadam.server.domain.user.entity.User;
import com.sodamdadam.server.domain.user.repository.UserRepository;
import com.sodamdadam.server.global.error.ErrorCode;
import com.sodamdadam.server.global.exception.SodamDadamException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class AccessTokenCheckService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public User checkAccessToken(HttpServletRequest httpServletRequest) {

        String bearerToken = jwtTokenProvider.resolveToken(httpServletRequest, JwtProperties.HEADER_ACCESS);

        String token = jwtTokenProvider.parseToken(bearerToken);

        if (token == null) {
            throw new SodamDadamException(ErrorCode.INVALID_JWT);
        }

        String findId = jwtTokenProvider.getTokenSubject(token);
        return userRepository.findById(findId)
                .orElseThrow(() -> new SodamDadamException(ErrorCode.USER_NOT_FOUND));
    }

}
