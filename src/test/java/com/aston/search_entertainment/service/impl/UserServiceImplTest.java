package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.entity.UserEntity;
import com.aston.search_entertainment.repository.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    private UserEntity user;

}