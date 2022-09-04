package com.aston.search_entertainment.controller;

import com.aston.search_entertainment.domain.dto.request.CommentRequest;
import com.aston.search_entertainment.domain.dto.request.CommentRequestForEdit;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;
import com.aston.search_entertainment.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @ApiOperation(value = "Get all comments")
    @GetMapping
    List<CommentResponse> getAllComments() {
        log.info("get all comments");
        return commentService.getListOfCommentDto();
    }

    @ApiOperation(value = "Get comment by id")
    @GetMapping({"/id"})
    CommentResponse getCommentById(@PathVariable(value = "id") Long id) {
        log.info("get comment by id");
        return commentService.getById(id);
    }

    @ApiOperation(value = "Create comment")
    @PostMapping
    CommentResponse createComment(@RequestBody CommentRequest commentRequest) {
        log.info("Receiving request for creating comment: {}", commentRequest);
        return commentService.createComment(commentRequest);
    }

    @ApiOperation(value = "Edit comment")
    @PutMapping
    CommentResponse editComment(@PathVariable Long id, @RequestBody CommentRequestForEdit commentRequest) {
        log.info("Receiving request for edit comment with id: {}", id);
        return commentService.editComment(id, commentRequest);
    }

    @DeleteMapping({"/id"})
    ResponseEntity<String> deleteCommentById(@PathVariable(value = "id") Long id) {
        log.info("Receiving request for deleting comment with id: {}", id);
        commentService.deleteCommentById(id);
        return ResponseEntity.ok("Comment delete successfully");
    }


}
