package com.sodamdadam.server.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors().disable()
//                .csrf().disable()
//                .formLogin().disable()
//                .httpBasic().disable()
//                .headers().frameOptions().disable();
        http.csrf().disable()
                .csrf().disable();
        http.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .headers().frameOptions().disable();

        return http.build();
    }

}
