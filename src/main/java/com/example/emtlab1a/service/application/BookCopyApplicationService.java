package com.example.emtlab1a.service.application;

import com.example.emtlab1a.dto.CreateAuthorDto;
import com.example.emtlab1a.dto.CreateBookCopyDto;
import com.example.emtlab1a.dto.DisplayBookCopyDto;
import com.example.emtlab1a.model.domain.Author;
import com.example.emtlab1a.model.domain.BookCopy;

import java.util.List;
import java.util.Optional;

public interface BookCopyApplicationService {
    List<DisplayBookCopyDto> findAll();
    Optional<DisplayBookCopyDto> save(CreateBookCopyDto bookCopy);

    Optional<DisplayBookCopyDto> findById(Long id);

    Optional<DisplayBookCopyDto> update(Long id, CreateBookCopyDto bookCopy);

    void deleteById(Long id);

    Optional<DisplayBookCopyDto> markAsRented(Long id);
    List<DisplayBookCopyDto> findByBook(Long id);
    public Optional<DisplayBookCopyDto> returnBook(Long id);
    Optional<DisplayBookCopyDto> createCopy(Long id);
}
