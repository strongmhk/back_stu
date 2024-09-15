package com.example.OAuthSession.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String role;

    @Builder
    public UserEntity(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public void updateUserInfo(String username, String email) {
        this.username = username;
        this.email = email;
    }

}