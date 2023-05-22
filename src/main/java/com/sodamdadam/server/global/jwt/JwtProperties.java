package com.sodamdadam.server.global.jwt;

public interface JwtProperties {

    String SECRET_KEY = "thekaekekaqlalfqjsghzldlqslek";
    Long EXPIRATION_TIME = 30 * 60 * 1000L;  //30분
    String TOKEN_PREFIX = "Bearer ";
    String HEADER = "Authorization";

}
