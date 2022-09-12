package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.entity.UserEntity;
import com.aston.search_entertainment.service.CurrentUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class CurrentUserServiceImpl implements CurrentUserService {
    private final UserDetailServiceImpl userDetailService;

    @Override
    public Optional<UserEntity> getCurrentUser() {
        log.info("Получение текущего пользователя из Security Context");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<UserEntity> result = Optional.of(userDetailService.getUserByEmail(auth.getName()));
        log.info("Текущеий пользователь из Security Context получен");
        return result;
    }
}
