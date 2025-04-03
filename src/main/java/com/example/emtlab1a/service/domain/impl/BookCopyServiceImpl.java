package com.example.emtlab1a.service.domain.impl;

import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.model.domain.BookCopy;
import com.example.emtlab1a.repository.BookCopyRepository;
import com.example.emtlab1a.service.domain.BookCopyService;
import com.example.emtlab1a.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookCopyServiceImpl implements BookCopyService {

    private final BookCopyRepository bookCopyRepository;
    private final BookService bookService;

    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository, BookService bookService) {
        this.bookCopyRepository = bookCopyRepository;
        this.bookService = bookService;
    }

    @Override
    public List<BookCopy> findAll() {
        return bookCopyRepository.findAll();
    }

    @Override
    public Optional<BookCopy> save(BookCopy bookCopy) {
        return Optional.empty();
    }

    @Override
    public Optional<BookCopy> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<BookCopy> update(Long id, BookCopy bookCopy) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<BookCopy> markAsRented(Long id) {
        BookCopy bookCopy = bookCopyRepository.findById(id).get();
        bookCopy.setIsRented(true);
        return Optional.of(bookCopy);
    }

    @Override
    public List<BookCopy> findByBook(Long id) {
        Book book = bookService.findById(id).get();
        return this.findAll().stream().filter(bookCopy -> bookCopy.getBook().equals(book)).collect(Collectors.toList());
    }


    @Override
    public Optional<BookCopy> returnBook(Long id) {
        BookCopy bookCopy = bookCopyRepository.findById(id).get();
        bookCopy.setIsRented(false);
        return Optional.of(bookCopy);
    }

    @Override
    public Optional<BookCopy> createCopy(Long id) {
        Book book = bookService.findById(id).get();
        BookCopy bookCopy = new BookCopy(book);
        bookCopyRepository.save(bookCopy);
        return Optional.of(bookCopy);
    }
}
