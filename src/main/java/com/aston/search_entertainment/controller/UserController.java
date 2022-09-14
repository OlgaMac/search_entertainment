package com.aston.search_entertainment.controller;

import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.mapper.UserMapper;
import com.aston.search_entertainment.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;


    @ApiOperation(value = "Get all users")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Студенты найдены",
            response = List.class)})
    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll();

    }

    @ApiOperation(value = "Get  User by id")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Пользователь не найден", response = RuntimeException.class)})
    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @ApiOperation("Delete user")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User delete");
    }

    @ApiOperation("Update user")
    @PutMapping
    public UserResponse updateUser(@RequestBody UserRequestUpdate update) {
        return userService.update(update);

    }
}
