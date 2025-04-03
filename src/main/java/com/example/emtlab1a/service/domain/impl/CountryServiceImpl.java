package com.example.emtlab1a.service.domain.impl;

import com.example.emtlab1a.model.domain.Country;
import com.example.emtlab1a.repository.CountryRepository;
import com.example.emtlab1a.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.of(countryRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public Optional<Country> save(Country country) {
        return Optional.of(countryRepository.save(new Country(country.getName(), country.getContinent())));
    }

    @Override
    public Optional<Country> update(Long id,Country country) {
        Optional<Country> countryToUpdate = this.findById(id);
        countryToUpdate.get().setName(country.getName());
        countryToUpdate.get().setContinent(country.getContinent());
        return Optional.of(countryRepository.save(countryToUpdate.get()));
    }

    @Override
    public void delete(Long id) {
        Optional<Country> country = this.findById(id);
        countryRepository.delete(country.get());
    }
}
