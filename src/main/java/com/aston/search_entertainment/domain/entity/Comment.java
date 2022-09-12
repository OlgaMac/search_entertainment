package com.aston.search_entertainment.domain.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comments")
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

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "entertainment_id")
    private Entertainment entertainment;

    @Column(nullable = false, name = "rating")
    private Double rating;

    @CreationTimestamp
    @Column(nullable = false, name = "created")
    private Timestamp created;

    @CreationTimestamp
    @Column(nullable = false, name = "updated")
    private Timestamp updated;
}
