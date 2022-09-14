package com.aston.search_entertainment.generators;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.Role;
import com.aston.search_entertainment.domain.entity.UserEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class EntityUserGenerator {
    private static final Long id = 1L;
    public static UserEntity generateUser(){
        UserEntity user = UserEntity.builder()
                .id(id)
                .email("mail@mail.com")
                .password("root")
                .role(Role.USER)
                .firstName("Ignat")
                .lastName("Petrov")
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .enabled(false)
                .build();
     return user;
    }

    public static UserResponse generateUserResponse(){
        UserResponse userResponse = UserResponse.builder().
                id(id)
                .email("mail@mail.com")
                .role("USER")
                .firstName("Ignat")
                .lastName("Petrov")
                .created(LocalDateTime.now())
                .build();
        return userResponse;

    }
    public  static UserRequest generateUserRequest(){
        UserRequest userRequest = UserRequest.builder()
                .email("mail@mail.com")
                .role("USER")
                .firstName("Ignat")
                .lastName("Petrov")
                .password("root")
                .build();
        return userRequest;
    }
    public static UserRequestUpdate generateUserRequestUpdate(){
        UserRequestUpdate update = UserRequestUpdate.builder()
                .id(id)
                .email("mail@mail.com")
                .firstName("Ignat")
                .lastName("Petrov")
                .build();
        return update;
    }
}

