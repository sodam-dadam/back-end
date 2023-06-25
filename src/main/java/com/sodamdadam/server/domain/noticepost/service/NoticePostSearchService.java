package com.sodamdadam.server.domain.noticepost.service;

import com.sodamdadam.server.domain.noticepost.entity.NoticePost;
import com.sodamdadam.server.domain.noticepost.repository.NoticePostRepository;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import com.sodamdadam.server.global.error.ErrorCode;
import com.sodamdadam.server.global.exception.SodamDadamException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class NoticePostSearchService {

    private final NoticePostRepository noticePostRepository;

    @Transactional
    public ResponseEntity<CommonResponse> getNoticePost(Long noticeId) {
        NoticePost findNoticePost = noticePostRepository.findByNoticeId(noticeId)
                .orElseThrow(() -> new SodamDadamException(ErrorCode.NOTICEPOST_NOT_FOUND));

        findNoticePost.addView();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("NoticePost Response Data Success")
                        .data(findNoticePost.getContent())
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }
}
