package com.sodamdadam.server.global.jwt;

public interface JwtProperties {

    String SECRET_KEY = "thekaekekaqlalfqjsghzldlqslek";
//    Long EXPIRATION_TIME = 30 * 60 * 1000L;  //30분
    Long ACCESS_EXPIRATION_TIME = 3 * 60 * 1000L; //3분
    Long REFRESH_EXPIRATION_TIME = 5 * 60 * 1000L; //5분

    String TOKEN_PREFIX = "Bearer ";
    String HEADER = "Authorization";

}
