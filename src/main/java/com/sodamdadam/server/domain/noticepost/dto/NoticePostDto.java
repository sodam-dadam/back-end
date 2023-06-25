package com.sodamdadam.server.domain.noticepost.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class NoticePostDto {

    private Long noticeId;
    private Long number;
    private String title;
    private String writer;
    private Date noticeDate;
    private Long view;

}
