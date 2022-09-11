package com.aston.search_entertainment.service;


import com.aston.search_entertainment.domain.entity.UserEntity;

import java.util.Optional;

public interface CurrentUserService {
    Optional<UserEntity> getCurrentUser();
}
