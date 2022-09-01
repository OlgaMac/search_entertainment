package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.UserEntity;

public interface UserMapper {

    UserResponse toResponse(UserEntity userEntity);

    UserEntity fromRequest(UserRequest userRequest);

    UserEntity fromRequestUpdate(UserRequestUpdate userRequestUpdate);

    UserEntity merge(UserEntity source, UserEntity target);
}
