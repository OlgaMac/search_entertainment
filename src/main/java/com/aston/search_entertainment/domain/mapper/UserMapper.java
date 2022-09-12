package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.dto.request.RegistrationRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserResponse toResponse(UserEntity userEntity);
    UserEntity fromRequest(UserRequest userRequest);
    UserEntity fromRequestUpdate(UserRequestUpdate userRequestUpdate);

    UserEntity fromRegistrationRequest(RegistrationRequest request);
}
