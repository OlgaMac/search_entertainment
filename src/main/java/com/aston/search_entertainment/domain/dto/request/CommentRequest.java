package com.aston.search_entertainment.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequest {

    private String text;

    private Long user_id;

    private Long entertainment_id;

    private Double rating;

    private Long rating_counter;
}
