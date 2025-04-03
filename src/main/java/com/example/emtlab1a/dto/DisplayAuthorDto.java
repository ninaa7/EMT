package com.example.emtlab1a.dto;

import com.example.emtlab1a.model.domain.Author;
import com.example.emtlab1a.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAuthorDto(Long id, String name, String surname, Country country) {
    public static DisplayAuthorDto from(Author author) {
        return new DisplayAuthorDto(author.getId(), author.getName(), author.getSurname(), author.getCountry());
    }

    public static List<DisplayAuthorDto> from(List<Author> authorList) {
        return authorList.stream().map(DisplayAuthorDto::from).collect(Collectors.toList());
    }

}
