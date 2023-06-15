package com.sodamdadam.server.global.jwt;

import com.sodamdadam.server.domain.user.entity.User;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class JwtTestController {

    private final AccessTokenCheckService accessTokenCheckService;
    private final RefreshTokenCheckService refreshTokenCheckService;

    //    엑세스 토큰으로 검증하는 컨트롤러
    @GetMapping("/accesstoken")
    public String checkAccessToken(HttpServletRequest httpServletRequest) {
        User findUser = accessTokenCheckService.checkAccessToken(httpServletRequest);
        return findUser.getId();
    }
    //    리프래쉬 토큰으로 엑세스 토큰 재발급하는 컨트롤러
    @GetMapping("/refreshtoken")
    public ResponseEntity<CommonResponse> checkRefreshToken(HttpServletRequest httpServletRequest) {
        return refreshTokenCheckService.checkRefreshToken(httpServletRequest);
    }

}
