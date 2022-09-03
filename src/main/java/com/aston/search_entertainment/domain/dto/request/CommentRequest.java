package com.aston.search_entertainment.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequest {

    private Long id;

    private String text;

    private Long user_id;

    private Long entertainment_id;

    private Double rating;

    private LocalDate created;

    private LocalDate updated;

}
