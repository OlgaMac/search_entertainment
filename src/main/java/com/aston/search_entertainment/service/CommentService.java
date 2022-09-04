package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.dto.request.CommentRequest;
import com.aston.search_entertainment.domain.dto.request.CommentRequestForEdit;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {

    /**
     * Find all Comments.
     *
     * @return list of CommentDto
     */
    List<CommentResponse> getListOfCommentDto();

    CommentResponse createComment(CommentRequest commentRequest);

    CommentResponse editComment(Long id, CommentRequestForEdit commentRequest);

}
