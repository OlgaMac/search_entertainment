package com.aston.search_entertainment.controller;

import com.aston.search_entertainment.domain.dto.request.CommentRequest;
import com.aston.search_entertainment.domain.dto.request.CommentRequestForEdit;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;
import com.aston.search_entertainment.domain.mapper.CommentMapper;
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
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @ApiOperation(value = "Get all comments")
    @GetMapping
    ResponseEntity<List<CommentResponse>> getAllComments() {
        log.info("get all comments");
        return ResponseEntity.ok(commentService.getListOfCommentDto());
    }

    @ApiOperation(value = "Get comment by id")
    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> findById(@PathVariable Long id) {
        CommentResponse result = Optional.of(id)
                .map(commentService::getById)
                .map(commentMapper::toCommentResponse)
                .orElseThrow();
        return new ResponseEntity<>(result, OK);
    }

    @ApiOperation(value = "Create comment")
    @PostMapping
    ResponseEntity<CommentResponse> createComment(@RequestBody CommentRequest commentRequest) {
        log.info("Receiving request for creating comment: {}", commentRequest);
        return ResponseEntity.ok(commentService.createComment(commentRequest));
    }

    @ApiOperation(value = "Edit comment")
    @PutMapping("/{id}")
    ResponseEntity<CommentResponse> editComment(@PathVariable Long id, @RequestBody CommentRequestForEdit commentRequest) {
        log.info("Receiving request for edit comment with id: {}", id);
        return ResponseEntity.ok(commentService.editComment(id, commentRequest));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCommentById(@PathVariable Long id) {
        log.info("Receiving request for deleting comment with id: {}", id);
        commentService.deleteCommentById(id);
        return ResponseEntity.ok("Comment delete successfully");
    }
}


