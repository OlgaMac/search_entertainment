package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.User;
import com.aston.search_entertainment.domain.mapper.UserMapper;
import com.aston.search_entertainment.repository.UserRepository;
import com.aston.search_entertainment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }

    @Override
    public Optional<UserEntity> findById(long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user;
    }

    @Override
    @Transactional
    public UserResponse save(UserRequest userRequest) {
        UserEntity user = userMapper.fromRequest(userRequest);
        userRepository.save(user);
        return userMapper.toResponse(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public UserResponse update(UserRequestUpdate update) {

        UserEntity user = userRepository.findById(update.getId()).get();

        user.setEmail(update.getEmail());

        user.setLastName(user.getLastName());

        user.setFirstName(user.getFirstName());

        userRepository.save(user);

        return userMapper.toResponse(user);
    }

}
