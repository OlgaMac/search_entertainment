package com.aston.search_entertainment.securety.controller;


import com.aston.search_entertainment.domain.dto.request.RegistrationRequest;
import com.aston.search_entertainment.service.RegistrationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.aston.search_entertainment.utils.UrlConstants.CONFIRM_URL;
import static com.aston.search_entertainment.utils.UrlConstants.MAIN_URL;
import static com.aston.search_entertainment.utils.UrlConstants.REGISTER_URL;
import static com.aston.search_entertainment.utils.UrlConstants.VERSION;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping(MAIN_URL + VERSION + REGISTER_URL)
@ApiOperation(value = "Регистрация", notes = "Регистрация пользователей")
public class RegistrationController {
    private final RegistrationService registrationService;

    @ApiOperation(value = "Регистрация пользователя")
    @ApiResponses(value = {@ApiResponse( code = 201, message = "Пользователи найдены"),
    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")})
    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        registrationService.register(request);
        return new ResponseEntity<>(CREATED);
    }

    @ApiOperation(value = "Подтверждение емейла пользователя с помощью токена")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Подтверждение успешно"),
    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")})

    @GetMapping(CONFIRM_URL)
    public ResponseEntity<?> confirm(@RequestParam String token) {
        registrationService.confirm(token);
        return new ResponseEntity<>(OK);
    }
}
