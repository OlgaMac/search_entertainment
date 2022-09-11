package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.dto.request.CommentRequest;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;
import com.aston.search_entertainment.domain.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = UserFromRepoMapper.class)
public interface CommentMapper {

    @Mapping(source = "user_id", target = "user", qualifiedByName = "getUserFromRepo")
    @Mapping(source = "entertainment_id", target = "entertainment", qualifiedByName = "getEntertainmentFromRepo")
    Comment toComment(CommentRequest request);

    @Mapping(target = "user_id", expression = "java(comment.getUser().getId())")
    @Mapping(target = "entertainment_id", expression = "java(comment.getEntertainment().getId())")
    CommentResponse toCommentResponse(Comment comment);


}
