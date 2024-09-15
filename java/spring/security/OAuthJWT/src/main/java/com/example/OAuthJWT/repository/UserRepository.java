package com.example.OAuthJWT.repository;

import com.example.OAuthJWT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}