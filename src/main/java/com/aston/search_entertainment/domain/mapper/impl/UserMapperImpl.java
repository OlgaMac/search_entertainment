package com.aston.search_entertainment.domain.mapper.impl;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.User;
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
    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        return userResponse
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setLastName(user.getLastName())
                .setFirstName(user.getFirstName())
                .setCreated(user.getCreated());
    }

    @Override
    public User fromRequest(UserRequest userRequest) {
        return objectMapper.convertValue(userRequest, User.class);
    }

    @Override
    public User fromRequestUpdate(UserRequestUpdate userRequestUpdate) {
        return objectMapper.convertValue(userRequestUpdate, User.class);
    }

}
