package com.aston.search_entertainment.service;


import com.aston.search_entertainment.domain.entity.ConfirmationToken;
import com.aston.search_entertainment.domain.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmailConfirmationTokenService {
    ConfirmationToken create(UserEntity userEntity);

    ConfirmationToken findByToken(String token);

    void delete(ConfirmationToken token);
}

