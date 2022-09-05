package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.dto.request.CommentRequest;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;
import com.aston.search_entertainment.domain.entity.Comment;
import org.mapstruct.InheritInverseConfiguration;
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


    @InheritInverseConfiguration
    CommentResponse toCommentResponse(Comment comment);


}
