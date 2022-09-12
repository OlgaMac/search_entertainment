package com.aston.search_entertainment.service.impl;


import com.aston.search_entertainment.domain.entity.ConfirmationToken;
import com.aston.search_entertainment.domain.entity.UserEntity;
import com.aston.search_entertainment.exception.EntityNotFoundException;
import com.aston.search_entertainment.repository.ConfirmationTokenRepository;
import com.aston.search_entertainment.service.EmailConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailConfirmationTokenServiceImpl implements EmailConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Value("${token.minutes-to-expire}")
    private long MINUTES_TO_EXPIRE;

    @Transactional
    @Override
    public ConfirmationToken create(UserEntity userEntity) {
        log.info("Создание сущности с токеном для подтвеждения email пользователя");
        String token = UUID.randomUUID().toString();
        LocalDateTime tokenExpires = LocalDateTime.now().plusMinutes(MINUTES_TO_EXPIRE);
        ConfirmationToken tokenEntity = new ConfirmationToken(token, userEntity, tokenExpires);
        ConfirmationToken result = confirmationTokenRepository.save(tokenEntity);
        log.info("Сущность с токеном для подтвеждения email пользователя создана");
        return result;
    }

    @Override
    public ConfirmationToken findByToken(String token) {
        log.info("Получение сущности ConfirmationToken c токеном: {}", token);
        ConfirmationToken result = confirmationTokenRepository.findByToken(token)
                .orElseThrow(() -> {
                    log.error("Сущность ConfirmationToken c токеном: {} не найдена", token);
                    throw new EntityNotFoundException("ConfirmationToken", "token", token);
                });
        log.info("Сущность ConfirmationToken c токеном: {} получена", token);
        return result;
    }

    @Override
    public void delete(ConfirmationToken token) {
        log.info("Удаление сущности ConfirmationToken c токеном: {}", token);
        confirmationTokenRepository.delete(token);
        log.info("Сущность ConfirmationToken c токеном: {} удалена", token);
    }
}
