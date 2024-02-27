package com.pedrom.demoparkapi.web.controller;

import com.pedrom.demoparkapi.entity.User;
import com.pedrom.demoparkapi.service.UserService;
import com.pedrom.demoparkapi.web.dto.UserCreateDto;
import com.pedrom.demoparkapi.web.dto.UserPasswordDto;
import com.pedrom.demoparkapi.web.dto.UserResponseDto;
import com.pedrom.demoparkapi.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserCreateDto createDto) {
        User user = userService.save(UserMapper.toUser(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable UUID id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updatePassword(@PathVariable UUID id, @RequestBody UserPasswordDto passwordDto) {

        User userUpdated = userService.updatePassword(id, passwordDto.getCurrentPassword(), passwordDto.getNewPassword(), passwordDto.getConfirmPassword());
        return ResponseEntity.ok(UserMapper.toDto(userUpdated));
    }
}
