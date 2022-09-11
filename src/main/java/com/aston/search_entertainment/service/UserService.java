package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.UserEntity;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<UserEntity> findAll ();
    Optional<UserEntity> findById(long id) throws ChangeSetPersister.NotFoundException;
    UserResponse save(UserRequest userRequest);
    void deleteById(Long id);
    UserResponse update(UserRequestUpdate update);

    UserEntity create(UserEntity userEntity);
}
