package com.sodamdadam.server.domain.user.controller;

import com.sodamdadam.server.domain.user.dto.request.UserJoinRequest;
import com.sodamdadam.server.domain.user.dto.request.UserLoginRequest;
import com.sodamdadam.server.domain.user.service.UserJoinService;
import com.sodamdadam.server.domain.user.service.UserLoginService;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import com.sodamdadam.server.global.dto.response.SuccessResponse;
import com.sodamdadam.server.global.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserJoinService userJoinService;
    private final UserLoginService userLoginService;
    @PostMapping("/join")
    public ResponseEntity<SuccessResponse> joinUser(@RequestBody @Valid UserJoinRequest request,
                                                    BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new ValidationException("유효성 검사 실패", errorMap);
        }

        return userJoinService.setUser(request);
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse> loginUser(@RequestBody @Valid UserLoginRequest request,
                                                    BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new ValidationException("유효성 검사 실패", errorMap);
        }

        return userLoginService.loginUser(request);
    }

}
