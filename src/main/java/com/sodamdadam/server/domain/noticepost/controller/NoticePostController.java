package com.sodamdadam.server.domain.noticepost.controller;

import com.sodamdadam.server.domain.noticepost.dto.request.NoticePostRegisterRequest;
import com.sodamdadam.server.domain.noticepost.service.NoticePostFindAllService;
import com.sodamdadam.server.domain.noticepost.service.NoticePostRegisterService;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import com.sodamdadam.server.global.dto.response.SuccessResponse;
import com.sodamdadam.server.global.exception.ValidationException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/noticeposts")
@RestController
public class NoticePostController {

    private final NoticePostRegisterService noticePostRegisterService;
    private final NoticePostFindAllService noticePostFindAllService;

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

    @GetMapping("/search")
    public ResponseEntity<CommonResponse> getNoticePost(@PageableDefault(size = 10) Pageable pageable) {
        return noticePostFindAllService.getNoticePosts(pageable);
    }
}
