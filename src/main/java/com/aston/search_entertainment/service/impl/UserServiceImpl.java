package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.entity.User;
import com.aston.search_entertainment.repository.UserRepository;
import com.aston.search_entertainment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
       List<User> users=userRepository.findAll();
       return users;
    }
}