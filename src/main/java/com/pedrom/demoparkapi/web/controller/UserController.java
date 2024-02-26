package com.pedrom.demoparkapi.web.controller;

import com.pedrom.demoparkapi.entity.User;
import com.pedrom.demoparkapi.service.UserService;
import com.pedrom.demoparkapi.web.dto.UserCreateDto;
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
    public ResponseEntity<User> getById(@PathVariable UUID id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updatePassword(@PathVariable UUID id, @RequestBody User user) {
        String password = user.getPassword();

        User userUpdated = userService.updatePassword(id, password);
        return ResponseEntity.ok(user);
    }
}
