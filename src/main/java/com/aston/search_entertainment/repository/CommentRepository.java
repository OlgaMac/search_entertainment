package com.aston.search_entertainment.repository;

import com.aston.search_entertainment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
