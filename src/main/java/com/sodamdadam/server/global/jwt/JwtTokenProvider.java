package com.sodamdadam.server.global.jwt;

import com.sodamdadam.server.global.error.ErrorCode;
import com.sodamdadam.server.global.exception.SodamDadamException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    public String createToken(String id) {

        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .setSubject(id)
                .claim("id",id)
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(JwtProperties.SECRET_KEY.getBytes()))
                .compact();

    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(JwtProperties.HEADER);
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

    public String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

}
