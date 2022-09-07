package com.aston.search_entertainment.repository;

import com.aston.search_entertainment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Modifying
    @Query("update Comment c set c.text = ?1 where c.id = ?2")
    void setCommentInfoById(String text, Long id);

    Comment getCommentById(Long id);
    Comment getRatingById(Long id);
    Comment getRatingCounter(Long id);
    @Modifying
    @Transactional
    @Query("update Comment c set c.rating = ?1, c.rating_counter = c.rating_counter +1 where c.id = ?2")
    void setRatingById(Double rating, Long id);
}
