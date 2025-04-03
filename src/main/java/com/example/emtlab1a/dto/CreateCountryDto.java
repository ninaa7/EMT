package com.example.emtlab1a.dto;

import com.example.emtlab1a.model.domain.Country;

public record CreateCountryDto(String name, String continent) {
    public Country toCountry() {
        return new Country(name, continent);
    }
}
