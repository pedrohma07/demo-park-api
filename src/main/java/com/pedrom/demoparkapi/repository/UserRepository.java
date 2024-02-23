package com.pedrom.demoparkapi.repository;

import com.pedrom.demoparkapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}