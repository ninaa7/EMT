package com.example.emtlab1a.dto;

import com.example.emtlab1a.model.enumerations.Role;
import com.example.emtlab1a.model.domain.User;

public record CreateUserDto(String username,
                            String password,
                            String repeatPassword,
                            String name,
                            String surname,
                            Role role
) {
    public User toUser() {
        return new User(username, password, name, surname, role);
    }
}
