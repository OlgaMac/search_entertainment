package com.aston.search_entertainment.service.impl;


import com.aston.search_entertainment.domain.dto.request.RegistrationRequest;
import com.aston.search_entertainment.domain.entity.ConfirmationToken;
import com.aston.search_entertainment.domain.entity.UserEntity;
import com.aston.search_entertainment.domain.mapper.UserMapper;
import com.aston.search_entertainment.exception.InvalidConfirmationTokenException;
import com.aston.search_entertainment.service.EmailConfirmationTokenService;
import com.aston.search_entertainment.service.EmailSenderService;
import com.aston.search_entertainment.service.RegistrationService;
import com.aston.search_entertainment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.aston.search_entertainment.domain.entity.Role.USER;
import static java.time.LocalDateTime.now;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;
    private final EmailConfirmationTokenService emailConfirmationTokenService;
    private final UserMapper userMapper;
    private final EmailSenderService emailSenderService;
    @Autowired
    public RegistrationServiceImpl(UserService userService, EmailConfirmationTokenService emailConfirmationTokenService, UserMapper userMapper, EmailSenderService emailSenderService) {
        this.userService = userService;
        this.emailConfirmationTokenService = emailConfirmationTokenService;
        this.userMapper = userMapper;
        this.emailSenderService = emailSenderService;
    }

    private final static String EMAIL_SUBJECT = "Подтверждение аккаунта";
    private final static String LINK = "http://localhost:8081/search_entertainment/api/v1.0/registration/confirm?token=";

    @Transactional
    @Override
    public void register(RegistrationRequest request) {
        log.info("Создание запроса на регистрацию пользователя с email: {}", request.getEmail());
        UserEntity userEntity = userMapper.fromRegistrationRequest(request);
        userEntity.setRole(USER);
        userEntity.setEnabled(false);
        userService.create(userEntity);
        ConfirmationToken token = emailConfirmationTokenService.create(userEntity);
        String head = String.format("<h1>Приветствуем вас, %s</h1>", userEntity.getEmail());
        String div1 = "<div>Добро пожаловать!</div>";
        String div2 = "<div>Для активации аккаунта пройдите по ссылке ниже.</div><br>";
        String linkWithToken = LINK + token.getToken();
        String button = String.format("<a href=\"%s\">Activate link</a>", linkWithToken);
        String resultMessage = head + div1 + div2 + button;
        emailSenderService.send(userEntity.getEmail(), EMAIL_SUBJECT, resultMessage);
        log.info("Запрос на регистрацию пользователя с email: {} создан", request.getEmail());
    }

    @Transactional
    @Override
    public void confirm(String token) {
        log.info("Подтверждение email через токен");
        ConfirmationToken confirmationToken = emailConfirmationTokenService.findByToken(token);
        LocalDateTime tokenExpiredDate = confirmationToken.getExpired();
        if (tokenExpiredDate.isBefore(now())) {
            log.error("Время действия токена истекло");
            userService.deleteById(confirmationToken.getUserEntity().getId());
            emailConfirmationTokenService.delete(confirmationToken);
            throw new InvalidConfirmationTokenException("Token is expired");
        }
        confirmationToken.getUserEntity().setEnabled(true);
        emailConfirmationTokenService.delete(confirmationToken);
        log.info("Подтверждение email через токен пройдено");
    }
}
