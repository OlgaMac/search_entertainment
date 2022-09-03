package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.User;

public interface UserMapper {

    UserResponse toResponse(User user);

    User fromRequest(UserRequest userRequest);

    User fromRequestUpdate(UserRequestUpdate userRequestUpdate);

}
