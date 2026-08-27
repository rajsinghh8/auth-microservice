package com.gab.authservice.dto;

import com.gab.authservice.entity.Role;
import com.gab.authservice.entity.User;

import java.util.UUID;

public record UserResponse(UUID id, String email, Role role) {

    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getRole());
    }
}
