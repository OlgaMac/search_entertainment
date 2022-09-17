package com.aston.search_entertainment.securety.controller;


import com.aston.search_entertainment.domain.dto.request.AuthenticationRequest;
import com.aston.search_entertainment.domain.entity.UserEntity;
import com.aston.search_entertainment.securety.jwt.JwtTokenProvider;
import com.aston.search_entertainment.service.impl.UserDetailServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.aston.search_entertainment.utils.UrlConstants.AUTH_URL;
import static com.aston.search_entertainment.utils.UrlConstants.LOGIN_URL;
import static com.aston.search_entertainment.utils.UrlConstants.LOGOUT_URL;
import static com.aston.search_entertainment.utils.UrlConstants.MAIN_URL;
import static com.aston.search_entertainment.utils.UrlConstants.VERSION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@RequiredArgsConstructor
@RestController
@RequestMapping(MAIN_URL + VERSION + AUTH_URL)
@ApiOperation(value = "Аутентификация", notes = "Работа с аутентификацией")
@Validated
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailServiceImpl userDetailService;

    @ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
    @ApiResponses(value = {@ApiResponse( code = 200, message = "Аутентификация пройдена успешно"),
    @ApiResponse(code = 400, message = "Внутренняя ошибка сервера"),
    @ApiResponse(code = 403, message = "Неверно введен емейл или пароль"),
    @ApiResponse(code = 402, message = "Неверно введен емейл")})
    @PostMapping(LOGIN_URL)
    @Validated
    public ResponseEntity<?> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            UserEntity userEntity = userDetailService.getUserByEmail( request.getEmail());
            String token = jwtTokenProvider.createToken(request.getEmail(), userEntity.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", request.getEmail());
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid email/password combination", FORBIDDEN);
        } 
    }

    @ApiOperation(value = "Выход")
    @ApiResponse(code = 200, message = "Выход произведен успешно")
    @PostMapping(LOGOUT_URL)
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
