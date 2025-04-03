package com.example.emtlab1a.service.domain;

import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(Book book);

    Optional<Book> update(Long id, Book book);

    void deleteById(Long id);

}
