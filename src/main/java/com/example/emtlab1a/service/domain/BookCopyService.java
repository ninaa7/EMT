package com.example.emtlab1a.service.domain;

import com.example.emtlab1a.model.domain.Author;
import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.model.domain.BookCopy;

import java.util.List;
import java.util.Optional;

public interface BookCopyService {
    List<BookCopy> findAll();
    Optional<BookCopy> save(BookCopy bookCopy);

    Optional<BookCopy> findById(Long id);

    Optional<BookCopy> update(Long id, BookCopy bookCopy);

    void deleteById(Long id);
    Optional<BookCopy> markAsRented(Long id);

    List<BookCopy> findByBook(Long id);
    public Optional<BookCopy> returnBook(Long id);
    Optional<BookCopy> createCopy(Long id);
}
