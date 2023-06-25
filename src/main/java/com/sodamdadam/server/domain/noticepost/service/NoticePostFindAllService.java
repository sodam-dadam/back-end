package com.sodamdadam.server.domain.noticepost.service;

import com.sodamdadam.server.domain.noticepost.dto.NoticePostDto;
import com.sodamdadam.server.domain.noticepost.dto.response.NoticePostFindAllResponse;
import com.sodamdadam.server.domain.noticepost.entity.NoticePost;
import com.sodamdadam.server.domain.noticepost.repository.NoticePostRepository;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticePostFindAllService {

    private final NoticePostRepository noticePostRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<CommonResponse> getNoticePosts(Pageable pageable) {
        Page<NoticePost> noticePosts = noticePostRepository.findAllByOrderByNoticeDate(pageable);
        List<NoticePostDto> noticePostDtos = noticePosts.stream()
                .map(noticePost -> {
                    int currentIndex = noticePosts.getContent().indexOf(noticePost);
                    long elementIndex = pageable.getPageNumber() * pageable.getPageSize() + currentIndex + 1;
                    return new NoticePostDto(
                            noticePost.getNoticeId(),
                            elementIndex,
                            noticePost.getTitle(),
                            noticePost.getWriter(),
                            noticePost.getNoticeDate(),
                            noticePost.getView()
                    );
                })
                .collect(Collectors.toList());

        NoticePostFindAllResponse<List<NoticePostDto>> response = new NoticePostFindAllResponse<>(
                noticePosts.getTotalElements(), Long.valueOf(noticePosts.getTotalPages()), noticePostDtos);

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("NoticePost Response Data Success")
                        .data(response)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }
}
