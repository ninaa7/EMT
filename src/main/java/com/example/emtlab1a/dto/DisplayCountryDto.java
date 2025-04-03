package com.example.emtlab1a.dto;

import com.example.emtlab1a.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayCountryDto(Long id, String name, String continent) {
    public static DisplayCountryDto from(Country country) {
        return new DisplayCountryDto(country.getId(), country.getName(), country.getContinent());
    }

    public static List<DisplayCountryDto> from(List<Country> categories) {
        return categories.stream().map(DisplayCountryDto::from).collect(Collectors.toList());
    }

}
