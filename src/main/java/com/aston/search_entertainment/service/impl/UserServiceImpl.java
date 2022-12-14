package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.UserEntity;
import com.aston.search_entertainment.domain.mapper.UserMapper;
import com.aston.search_entertainment.exception.EntityAlreadyExistsException;
import com.aston.search_entertainment.repository.UserRepository;
import com.aston.search_entertainment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, UserMapper userMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserEntity> findAll() {
       List<UserEntity> userEntities =userRepository.findAll();
       return userEntities;
    }

    @Override
    public Optional<UserEntity> findById(long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user;
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

    @Override
    @Transactional
    public UserEntity create(UserEntity userEntity) {
        log.info("???????????????? ????????????????????????");
        if (userRepository.findByEmail(userEntity.getEmail()).isPresent()) {
            throw new EntityAlreadyExistsException("User", "email", userEntity.getEmail());
        }
        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encodedPassword);
        UserEntity result = userRepository.save(userEntity);
        log.info("???????????????????????? ????????????");
        return result;
    }


}
