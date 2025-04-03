package com.example.emtlab1a.service.application;

import com.example.emtlab1a.dto.BookDto;
import com.example.emtlab1a.dto.CreateBookDto;
import com.example.emtlab1a.dto.DisplayBookDto;
import com.example.emtlab1a.model.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    List<DisplayBookDto> findAll();

    Optional<DisplayBookDto> findById(Long id);

    Optional<DisplayBookDto> save(CreateBookDto book);

    Optional<DisplayBookDto> update(Long id, CreateBookDto book);

    void deleteById(Long id);

}
