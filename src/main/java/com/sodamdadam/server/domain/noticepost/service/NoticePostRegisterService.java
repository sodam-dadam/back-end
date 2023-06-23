package com.sodamdadam.server.domain.noticepost.service;

import com.sodamdadam.server.domain.noticepost.dto.request.NoticePostRegisterRequest;
import com.sodamdadam.server.domain.noticepost.entity.NoticePost;
import com.sodamdadam.server.domain.noticepost.repository.NoticePostRepository;
import com.sodamdadam.server.global.dto.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class NoticePostRegisterService {

    private final NoticePostRepository noticePostRepository;

    @Transactional
    public ResponseEntity<SuccessResponse> setNoticePost(NoticePostRegisterRequest request) {

        NoticePost noticePost = createNoticePostFromRequest(request);

        noticePostRepository.save(noticePost);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SuccessResponse.builder()
                        .status(HttpStatus.CREATED.value())
                        .message("NoticePost Register Success")
                        .build());
    }

    private NoticePost createNoticePostFromRequest(NoticePostRegisterRequest request) {
        return NoticePost.builder()
                .title(request.getTitle())
                .writer(request.getWriter())
                .content(request.getContent())
                .notiecDate(new Date())
                .build();
    }
}
