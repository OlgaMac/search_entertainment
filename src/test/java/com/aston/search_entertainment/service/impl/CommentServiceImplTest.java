package com.aston.search_entertainment.service.impl;

import static com.aston.search_entertainment.generators.EntitiesGenerator.generateComment;
import static com.aston.search_entertainment.generators.EntitiesGenerator.generateCommentRequest;
import static com.aston.search_entertainment.generators.EntitiesGenerator.generateCommentResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aston.search_entertainment.domain.dto.request.CommentRequest;
import com.aston.search_entertainment.domain.dto.request.CommentRequestForEdit;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;
import com.aston.search_entertainment.domain.entity.Comment;
import com.aston.search_entertainment.domain.mapper.CommentMapper;
import com.aston.search_entertainment.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    private Comment comment;

    private CommentRequest commentRequest;

    private CommentResponse commentResponse;

    private CommentRequestForEdit commentRequestForEdit;

    @InjectMocks
    CommentServiceImpl commentService;

    @Mock
    CommentRepository commentRepository;

    @Mock
    CommentMapper commentMapper;

    @BeforeEach
    void initialize() {
        comment = generateComment();
        commentRequest = generateCommentRequest();
        commentResponse = generateCommentResponse();
        commentRequestForEdit = new CommentRequestForEdit("update");
    }

    void assertEqualsRequestAndResponse(CommentRequest request, CommentResponse response) {
        assertEquals(request.getUser_id(), response.getUser_id());
        assertEquals(request.getText(), response.getText());
        assertEquals(request.getEntertainment_id(), response.getEntertainment_id());
        assertEquals(request.getRating(), response.getRating());
    }

//    @Test
//    void getById() {
//        Mockito
//                .when(commentRepository.getCommentById(1L))
//                .thenReturn(comment);
//
//        Mockito
//                .when(commentMapper.toCommentResponse(comment))
//                .thenReturn(commentResponse);
//
//        CommentResponse result = commentService.getById(1L);
//
//        assertEquals(1L, result.getId());
//
//    }

    @Test
    void getListOfCommentDto() {

        commentService.getListOfCommentDto();

        Mockito.verify(commentRepository, Mockito.times(1))
                .findAll();

    }

//    @Test
//    void createComment() {
//        Mockito
//                .when(commentRepository.save(comment))
//                .thenReturn(comment);
//
//        Mockito
//                .when(commentMapper.toComment(commentRequest))
//                .thenReturn(comment);
//
//        Mockito
//                .when(commentMapper.toCommentResponse(comment))
//                .thenReturn(commentResponse);
//
//        CommentResponse result = commentService.createComment(commentRequest);
//
//        assertEqualsRequestAndResponse(commentRequest, result);
//
//        Mockito
//                .verify(commentRepository, Mockito.times(1))
//                .save(comment);
//    }

    @Test
    void editComment() {
        Mockito
                .when(commentRepository.getCommentById(1L))
                .thenReturn(comment);

        commentService.editComment(1L, commentRequestForEdit);

        Mockito.verify(commentRepository, Mockito.times(1))
                .setCommentInfoById(commentRequestForEdit.getText(), 1L);

        Mockito.verify(commentMapper, Mockito.times(1))
                .toCommentResponse(comment);
    }

    @Test
    void deleteCommentById() {
        commentService.deleteCommentById(1L);

        Mockito
                .verify(commentRepository, Mockito.times(1))
                .deleteById(1L);
    }
}
