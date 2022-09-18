package com.aston.search_entertainment.service;


import com.aston.search_entertainment.domain.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface CurrentUserService {
    Optional<UserEntity> getCurrentUser();
}
