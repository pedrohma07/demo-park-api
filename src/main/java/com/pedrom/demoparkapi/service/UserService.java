package com.pedrom.demoparkapi.service;

import com.pedrom.demoparkapi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.pedrom.demoparkapi.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User save(User user) {
        return userRepository.save(user);
    }



    @Transactional(readOnly = true)
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }


    @Transactional // anotação para garantir que a transação seja realizada
    public User updatePassword(UUID id, String password) {
        User user = findById(id);

        System.out.println(user);

        user.setPassword(password);
        return user;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
