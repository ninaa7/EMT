package com.example.emtlab1a.service.domain;

import com.example.emtlab1a.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> save(Country country);
    Optional<Country> update(Long id, Country country);
    void delete(Long id);
}
