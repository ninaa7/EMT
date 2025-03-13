package com.example.emtlab1a.service.impl;

import com.example.emtlab1a.model.Book;
import com.example.emtlab1a.model.dto.BookDto;
import com.example.emtlab1a.repository.BookRepository;
import com.example.emtlab1a.service.AuthorService;
import com.example.emtlab1a.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto book) {
        if(book.getName() !=null &&
                authorService.findById(book.getAuthor()).isPresent() &&
                book.getCategory() !=null &&
                book.getAvailableCopies() !=null
        ){
            return Optional.of(
                    bookRepository.save(new Book(book.getName(),book.getCategory(),authorService.findById(book.getAuthor()).get(),book.getAvailableCopies()))
            );
        }
        return Optional.empty();
    }


    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book = this.findById(id).get();
        if (bookDto.getAuthor() != null) {
            book.setAuthor(authorService.findById(bookDto.getAuthor()).get());
        }
        if (bookDto.getCategory() != null) {
            book.setCategory(bookDto.getCategory());
        }
        if (bookDto.getAvailableCopies() != null) {
            book.setAvailableCopies(bookDto.getAvailableCopies());
        }
        if (bookDto.getName() != null) {
            book.setName(bookDto.getName());
        }
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> markAsRented(Long id) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    if (existingBook.getAvailableCopies() > 0) {
                        existingBook.setAvailableCopies(existingBook.getAvailableCopies() - 1);
                    }
                    return bookRepository.save(existingBook);
                });
    }
}
