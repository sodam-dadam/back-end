package com.sodamdadam.server.domain.noticepost.entity;

import com.sodamdadam.server.domain.user.enums.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_noticepost")
@Entity
public class NoticePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long noticeId;

    private String title;

    private String writer;

    private String content;

    @Column(name = "notice_date")
    @Temporal(TemporalType.DATE)
    private Date notiecDate;

    private Long view;

    @Builder
    public NoticePost(String title, String writer, String content, Date notiecDate, Long view) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.notiecDate = notiecDate;
        this.view = view;
    }
}
