package com.pedrom.demoparkapi.web.controller;

import com.pedrom.demoparkapi.entity.User;
import lombok.RequiredArgsConstructor;
import com.pedrom.demoparkapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
//    public ResponseEntity<User> create(User user) {
//
//    }
}
