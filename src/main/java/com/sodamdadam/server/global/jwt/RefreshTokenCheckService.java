package com.sodamdadam.server.global.jwt;

import com.sodamdadam.server.domain.user.dto.response.UserLoginResponse;
import com.sodamdadam.server.domain.user.entity.User;
import com.sodamdadam.server.domain.user.repository.UserRepository;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import com.sodamdadam.server.global.error.ErrorCode;
import com.sodamdadam.server.global.exception.SodamDadamException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class RefreshTokenCheckService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final RedisTemplate redisTemplate;

    public ResponseEntity<CommonResponse> checkRefreshToken(HttpServletRequest httpServletRequest) {
        // 엑세스 토큰이 조작되었는지 확인
        String bearerAccessToken = jwtTokenProvider.resolveToken(httpServletRequest, JwtProperties.HEADER_ACCESS);
        String bearerRefreshToken = jwtTokenProvider.resolveToken(httpServletRequest, JwtProperties.HEADER_REFRESH);
        String accessToken = jwtTokenProvider.parseToken(bearerAccessToken);
        String refreshToken = jwtTokenProvider.parseToken(bearerRefreshToken);

        if (accessToken == null || refreshToken == null) {
            throw new SodamDadamException(ErrorCode.INVALID_JWT);
        }

        boolean status = jwtTokenProvider.validateAccessToken(accessToken);

        if (status == false) {
            throw new SodamDadamException(ErrorCode.INVALID_JWT);
        }

        // 레디스 내부의 리프래쉬 토큰 확인하기
        String findId = jwtTokenProvider.getTokenSubject(accessToken);
        userRepository.findById(findId)
                .orElseThrow(() -> new SodamDadamException(ErrorCode.USER_NOT_FOUND));
        jwtTokenProvider.getTokenSubject(refreshToken);

        String refreshTokenFromRedis = (String)redisTemplate.opsForValue().get(findId);

        // 전달받은 리프레시 토큰과 레디스에 저장된 리프레시 토큰이 동일한지 확인하기.
        if (!refreshToken.equals(refreshTokenFromRedis)) {
            throw new SodamDadamException(ErrorCode.INVALID_JWT);
        }

        // 엑세스 토큰 재생성
        String newAccessToken = jwtTokenProvider.createAccessToken(findId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("Access token reissuance Success")
                        .data(new UserLoginResponse(JwtProperties.TOKEN_PREFIX + newAccessToken,
                                JwtProperties.TOKEN_PREFIX + refreshToken))
                        .build());
    }

}
