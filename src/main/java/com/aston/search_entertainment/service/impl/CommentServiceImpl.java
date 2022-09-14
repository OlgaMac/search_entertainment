package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.CommentRequest;
import com.aston.search_entertainment.domain.dto.request.CommentRequestForEdit;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;
import com.aston.search_entertainment.domain.entity.Comment;
import com.aston.search_entertainment.domain.mapper.CommentMapper;
import com.aston.search_entertainment.exception.EntityNotFoundException;
import com.aston.search_entertainment.repository.CommentRepository;
import com.aston.search_entertainment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;

    @Override
    public List<CommentResponse> getListOfCommentDto() {
        log.debug("get countries");
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toCommentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CommentResponse createComment(CommentRequest commentRequest) {
        log.debug("create comment");
        Comment comment = commentMapper.toComment(commentRequest);
        commentRepository.save(comment);

        return commentMapper.toCommentResponse(comment);
    }

    @Override
    public CommentResponse editComment(Long id, CommentRequestForEdit commentRequest) {
        commentRepository.setCommentInfoById(commentRequest.getText(), id);

        return commentMapper.toCommentResponse(commentRepository.getCommentById(id));
    }

    @Override
    public CommentResponse getById(Long id) {
        Comment comment = commentRepository.getCommentById(id);
        if (comment == null) {
            throw new NoSuchElementException("Comment not found with id : " + id);
        }
        return commentMapper.toCommentResponse(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
}
