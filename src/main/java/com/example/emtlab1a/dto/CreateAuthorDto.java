package com.example.emtlab1a.dto;

import com.example.emtlab1a.model.domain.Author;
import com.example.emtlab1a.model.domain.Country;

public record CreateAuthorDto(String name, String surname, Country country) {
    public Author toAuthor() {
        return new Author(name, surname, country);
    }
}
