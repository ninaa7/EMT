package com.example.emtlab1a.dto;

import com.example.emtlab1a.model.enumerations.Role;
import com.example.emtlab1a.model.domain.User;


public record DisplayUserDto(String username, String name, String surname, Role role) {
    public static DisplayUserDto from(User user) {
        return new DisplayUserDto(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getRole()
        );
    }

    public User toUser() {
        return new User(username, name, surname, role.name());
    }

}
