package com.pedrom.demoparkapi.service;

import com.pedrom.demoparkapi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.pedrom.demoparkapi.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(String id) {
        UUID uuid = UUID.fromString(id);
        return userRepository.findById(uuid).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }
}
