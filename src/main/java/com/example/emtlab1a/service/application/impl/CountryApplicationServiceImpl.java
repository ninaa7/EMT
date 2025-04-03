package com.example.emtlab1a.service.application.impl;

import com.example.emtlab1a.dto.CreateCountryDto;
import com.example.emtlab1a.dto.DisplayCountryDto;
import com.example.emtlab1a.service.application.CountryApplicationService;
import com.example.emtlab1a.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return countryService.findAll().stream().map(DisplayCountryDto::from).collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto country) {
        return countryService.save(country.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto country) {
        return countryService.update(id, country.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public void delete(Long id) {
        countryService.delete(id);
    }
}
