package com.aston.search_entertainment.controller;

import com.aston.search_entertainment.domain.dto.request.CommentRequest;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;
import com.aston.search_entertainment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/comments")
@RequiredArgsConstructor
@RestController
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    List<CommentResponse> getAllComments() {
        log.info("get all comments");
        return commentService.getListOfCommentDto();
    }

    @PostMapping
    CommentResponse createComment(@RequestBody CommentRequest commentRequest) {
        log.info("Receiving request for creating account: {}", commentRequest);
        return commentService.createComment(commentRequest);
    }

}
