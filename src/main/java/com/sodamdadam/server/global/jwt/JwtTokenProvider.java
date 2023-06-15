package com.sodamdadam.server.global.jwt;

import com.sodamdadam.server.global.error.ErrorCode;
import com.sodamdadam.server.global.exception.SodamDadamException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final RedisTemplate<String, String> redisTemplate;

    public String createAccessToken(String id) {

        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JwtProperties.ACCESS_EXPIRATION_TIME))
                .setSubject(id)
                .claim("id",id)
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(JwtProperties.SECRET_KEY.getBytes()))
                .compact();

    }

    public String createRefreshToken(String id) {

        String refreshToken = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JwtProperties.REFRESH_EXPIRATION_TIME))
                .setSubject(id)
                .claim("id", id)
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(JwtProperties.SECRET_KEY.getBytes()))
                .compact();

        // redis에 저장
        redisTemplate.opsForValue().set(
                id,
                refreshToken,
                JwtProperties.REFRESH_EXPIRATION_TIME,
                TimeUnit.MILLISECONDS
        );

        return refreshToken;

    }

    public String resolveToken(HttpServletRequest request, String tokenType) {
        String bearer = request.getHeader(tokenType);
        return bearer;
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(JwtProperties.TOKEN_PREFIX))
            return bearerToken.replace(JwtProperties.TOKEN_PREFIX, "");

        return null;
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(Base64.getEncoder()
                            .encodeToString(JwtProperties.SECRET_KEY.getBytes()))
                    .parseClaimsJws(token).getBody();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw new SodamDadamException(ErrorCode.EXPIRED_JWT);
        } catch (Exception e) {
            throw new SodamDadamException(ErrorCode.INVALID_JWT);
        }
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(JwtProperties.SECRET_KEY.getBytes()))
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            return true;
        } catch (MalformedJwtException e) {
            return false;
        } catch (SignatureException e) {
            return false;
        } catch (UnsupportedJwtException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


    public String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

}
