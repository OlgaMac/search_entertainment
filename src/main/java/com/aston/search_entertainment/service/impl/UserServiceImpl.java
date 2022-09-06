package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdateRole;
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
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public Optional<User> findById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    @Transactional
    public UserResponse save(UserRequest userRequest) {
        User user = userMapper.fromRequest(userRequest);
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
        User user = userMapper.fromRequestUpdate(update);
        Optional<User> userOptional = userRepository.findById(user.getId());
        User newUser = userOptional.get();
        if (user.getEmail() == null) {
            newUser.setEmail(newUser.getEmail());
        } else {
            newUser.setEmail(user.getEmail());
        }
        if (user.getPassword() == null) {
            newUser.setPassword(newUser.getPassword());
        } else {
            newUser.setPassword(user.getPassword());
        }
        if (user.getLastName() == null) {
            newUser.setLastName(newUser.getLastName());
        } else {
            newUser.setLastName(user.getLastName());
        }
        if (user.getFirstName() == null) {
            newUser.setFirstName(newUser.getFirstName());
        } else {
            newUser.setFirstName(user.getFirstName());
        }
        userRepository.save(newUser);
        return userMapper.toResponse(newUser);
    }

    @Override
    @Transactional
    public UserResponse updateRole(UserRequestUpdateRole updateRole) {
        User user = userMapper.fromRequestUpdateRole(updateRole);
        Optional<User> userOptional = userRepository.findById(user.getId());
        User newUser = userOptional.get();
        newUser.setRole(user.getRole());
        userRepository.save(newUser);
        return userMapper.toResponse(newUser);
    }

}
