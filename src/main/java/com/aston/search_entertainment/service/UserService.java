package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserResponse> findAll();

    UserResponse getById(Long id);

    void deleteById(Long id);

    UserResponse update(UserRequestUpdate update);

    UserEntity create(UserEntity userEntity);
}
