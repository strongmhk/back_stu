package com.example.security2.repository;

import com.example.security2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

// repository 구현체를 자동으로 주입됨
// @Repository가 없어도 자동으로 빈으로 등록됨
public interface UserRepository extends JpaRepository<User, Long> {

    // Query Method
    // select * from User u where username = :username;
    public User findByUsername(String username);
}
