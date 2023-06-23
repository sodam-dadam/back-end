package com.sodamdadam.server.domain.noticepost.controller;

import com.sodamdadam.server.domain.noticepost.dto.request.NoticePostRegisterRequest;
import com.sodamdadam.server.domain.noticepost.service.NoticePostRegisterService;
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
@RequestMapping("/noticeposts")
@RestController
public class NoticePostController {

    private final NoticePostRegisterService noticePostRegisterService;

    @PostMapping("/register")
    public ResponseEntity<SuccessResponse> setNoticePost(@RequestBody @Valid NoticePostRegisterRequest request,
                                                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new ValidationException("유효성 검사 실패", errorMap);
        }

        return noticePostRegisterService.setNoticePost(request);
    }
}
