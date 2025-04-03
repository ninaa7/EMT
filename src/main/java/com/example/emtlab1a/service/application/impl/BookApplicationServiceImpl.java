package com.example.emtlab1a.service.application.impl;

import com.example.emtlab1a.dto.CreateBookDto;
import com.example.emtlab1a.dto.DisplayBookDto;
import com.example.emtlab1a.model.domain.Author;
import com.example.emtlab1a.model.enumerations.BookCategory;
import com.example.emtlab1a.service.application.BookApplicationService;
import com.example.emtlab1a.service.domain.AuthorService;
import com.example.emtlab1a.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookApplicationServiceImpl implements BookApplicationService {

    private final BookService bookService;
    private final AuthorService authorService;


    public BookApplicationServiceImpl(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return bookService.findAll().stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayBookDto> findById(Long id) {
        return bookService.findById(id).map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> save(CreateBookDto book) {
        Optional<Author> author = authorService.findById(book.author().getId());
        BookCategory bookCategory = BookCategory.valueOf(book.category().name());
        return bookService.save(book.toBook(bookCategory,author.get())).map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, CreateBookDto book) {
        Optional<Author> author = authorService.findById(book.author().getId());
        BookCategory bookCategory = BookCategory.valueOf(book.category().name());
        return bookService.update(id,book.toBook(bookCategory,author.get())).map(DisplayBookDto::from);
    }

    @Override
    public void deleteById(Long id) {
        bookService.deleteById(id);
    }

}
