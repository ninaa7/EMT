package com.example.emtlab1a.service.application;

import com.example.emtlab1a.dto.CreateCountryDto;
import com.example.emtlab1a.dto.DisplayCountryDto;
import com.example.emtlab1a.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> findById(Long id);
    Optional<DisplayCountryDto> save(CreateCountryDto country);
    Optional<DisplayCountryDto> update(Long id, CreateCountryDto country);
    void delete(Long id);
}
