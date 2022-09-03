package com.aston.search_entertainment.domain.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comments_id")
    @GenericGenerator(name = "seq_comments_id", strategy = "sequence",
                parameters = {@Parameter(name = "sequence", value = "seq_comments_id")})
    private Long id;

    @Column(nullable = false, name = "text")
    @NotBlank
    private String text;

    @Column(nullable = false, name = "user id")
    @NotNull
    private UserEntity user;

    @Column(nullable = false, name = "entertainment_id")
    @NotNull
    private EntertainmentEntity entertainment;

    @Column(nullable = false, name = "rating")
    private Double rating;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "created")
    private LocalDate created;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "updated")
    private LocalDate updated;
}
