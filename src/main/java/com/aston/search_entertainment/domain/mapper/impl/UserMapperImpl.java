package com.aston.search_entertainment.domain.mapper.impl;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.UserEntity;
import com.aston.search_entertainment.domain.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    private final ObjectMapper objectMapper;

    public UserMapperImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public UserResponse toResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        return userResponse
                .setId(userEntity.getId())
                .setEmail(userEntity.getEmail())
                .setLastName(userEntity.getLastName())
                .setFirstName(userEntity.getFirstName())
                .setCreated(userEntity.getCreated());
    }

    @Override
    public UserEntity fromRequest(UserRequest userRequest) {
        return objectMapper.convertValue(userRequest, UserEntity.class);
    }

    @Override
    public UserEntity fromRequestUpdate(UserRequestUpdate userRequestUpdate) {
        return objectMapper.convertValue(userRequestUpdate, UserEntity.class);
    }

    @Override
    public UserEntity merge(UserEntity source, UserEntity target) {
        return null;
    }
}
