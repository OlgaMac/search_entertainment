package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.dto.request.CommentRequest;
import com.aston.search_entertainment.domain.dto.request.CommentResponse;
import com.aston.search_entertainment.domain.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CommentMapper {

    Comment toComment(CommentRequest request);

    CommentResponse toCommentResponse(Comment comment);
}
