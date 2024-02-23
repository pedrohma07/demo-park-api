package com.pedrom.demoparkapi.repository;

import com.pedrom.demoparkapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}