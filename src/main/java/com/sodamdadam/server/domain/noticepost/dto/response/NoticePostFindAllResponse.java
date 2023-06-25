package com.sodamdadam.server.domain.noticepost.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NoticePostFindAllResponse<T> {
    private Long totalDataCount;
    private Long totalPageCount;
    private T noticePost;
}
