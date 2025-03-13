package com.example.emtlab1a.service;

import com.example.emtlab1a.model.Book;
import com.example.emtlab1a.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto book);

    Optional<Book> update(Long id, BookDto book);

    void deleteById(Long id);

    Optional<Book> markAsRented(Long id);

}
