package com.sodamdadam.server.domain.noticepost.repository;

import com.sodamdadam.server.domain.noticepost.entity.NoticePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticePostRepository extends JpaRepository<NoticePost, Long> {
}
