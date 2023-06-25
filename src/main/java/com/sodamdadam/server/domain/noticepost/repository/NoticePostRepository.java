package com.sodamdadam.server.domain.noticepost.repository;

import com.sodamdadam.server.domain.noticepost.entity.NoticePost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoticePostRepository extends JpaRepository<NoticePost, Long> {
    Page<NoticePost> findAllByOrderByNoticeDate(Pageable pageable);

    Optional<NoticePost> findByNoticeId(Long id);
}
