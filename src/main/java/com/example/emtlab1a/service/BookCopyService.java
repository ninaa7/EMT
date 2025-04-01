package com.example.emtlab1a.service;

import com.example.emtlab1a.model.Author;
import com.example.emtlab1a.model.BookCopy;

import java.util.List;
import java.util.Optional;

public interface BookCopyService {
    List<BookCopy> findAll();
    Optional<BookCopy> save(Author author);

    Optional<BookCopy> findById(Long id);

    Optional<BookCopy> update(Long id, Author author);

    void deleteById(Long id);
}
