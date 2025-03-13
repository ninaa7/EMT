package com.example.emtlab1a.repository;

import com.example.emtlab1a.model.Author;
import com.example.emtlab1a.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
