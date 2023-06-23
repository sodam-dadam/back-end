package com.sodamdadam.server.domain.noticepost.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticePostRegisterRequest {

    @NotEmpty
    private String title;
    @NotEmpty
    private String writer;
    @NotEmpty
    private String content;

    @Builder
    public NoticePostRegisterRequest(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
