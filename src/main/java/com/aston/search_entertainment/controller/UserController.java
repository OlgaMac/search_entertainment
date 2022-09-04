package com.aston.search_entertainment.controller;

import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.entity.User;
import com.aston.search_entertainment.domain.mapper.UserMapper;
import com.aston.search_entertainment.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @ApiOperation(value = "Получение всех пользователей")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Студенты найдены",
            response = List.class)})
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> result = userService.findAll()
                .stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, OK);

    }
    @ApiOperation(value = "Получение пользователя по id")
    @ApiResponses(value = {@ApiResponse(code = 404,message = "Стедент не найден",response = List.class)})
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable long id) {
         UserResponse result = userService.findById(id)
                 .stream()
                 .map(userMapper::toResponse)
                 .findAny().get();
         return new ResponseEntity<>(result,OK);
    }
}
