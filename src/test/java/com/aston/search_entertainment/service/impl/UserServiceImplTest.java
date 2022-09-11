package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.User;
import com.aston.search_entertainment.domain.mapper.UserMapper;
import com.aston.search_entertainment.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.aston.search_entertainment.generators.EntityUserGenerator.generateUser;
import static com.aston.search_entertainment.generators.EntityUserGenerator.generateUserRequest;
import static com.aston.search_entertainment.generators.EntityUserGenerator.generateUserRequestUpdate;
import static com.aston.search_entertainment.generators.EntityUserGenerator.generateUserResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private User user;
    private UserRequest userRequest;
    private UserResponse userResponse;
    private UserRequestUpdate userRequestUpdate;
    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;
    @Mock
    UserMapper userMapper;

    @BeforeEach
    void generate() {
        user = generateUser();
        userResponse = generateUserResponse();
        userRequest = generateUserRequest();
        userRequestUpdate = generateUserRequestUpdate();

    }
    void assertEqualsRequestAndResponse(UserResponse userResponse,UserRequest userRequest){
       assertEquals(userRequest.getEmail(),userResponse.getEmail());
       assertEquals(userRequest.getFirstName(),userResponse.getFirstName());
       assertEquals(userRequest.getLastName(),userResponse.getLastName());
       assertEquals(userRequest.getRole(),userResponse.getRole());
    }


}
