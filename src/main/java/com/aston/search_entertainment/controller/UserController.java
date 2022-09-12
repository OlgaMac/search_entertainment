package com.aston.search_entertainment.controller;

import com.aston.search_entertainment.domain.dto.request.UserRequest;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.UserResponse;
import com.aston.search_entertainment.domain.mapper.UserMapper;
import com.aston.search_entertainment.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;


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
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Пользователь не найден", response = RuntimeException.class)})
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable long id) {
        UserResponse result = null;
        try {
            result = userService.findById(id)
                    .stream()
                    .map(userMapper::toResponse)
                    .findAny().get();
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(result, OK);
    }
    @ApiOperation(value = "Создание нового пользователя")
    @PostMapping()
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);

    }

    @ApiOperation("Удаление пользователя")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User delete");
    }

    @ApiOperation("Обновление пользователя")
    @PutMapping
    public UserResponse updateUser(@RequestBody UserRequestUpdate update){
        return userService.update(update);

    }

}
