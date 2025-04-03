package com.example.emtlab1a.service.domain.impl;

import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.model.domain.BookCopy;
import com.example.emtlab1a.dto.BookDto;
import com.example.emtlab1a.repository.BookRepository;
import com.example.emtlab1a.service.domain.AuthorService;
import com.example.emtlab1a.service.domain.BookService;
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
    public Optional<Book> save(Book book) {
        if(book.getName() !=null &&
                authorService.findById(book.getAuthor().getId()).isPresent() &&
                book.getCategory() !=null
        ){
            return Optional.of(
                    bookRepository.save(new Book(book.getName(),book.getCategory(),authorService.findById(book.getAuthor().getId()).get()))
            );
        }
        return Optional.empty();
    }


    @Override
    public Optional<Book> update(Long id, Book bookDto) {
        Book book = this.findById(id).get();
        if (bookDto.getAuthor() != null) {
            book.setAuthor(authorService.findById(bookDto.getAuthor().getId()).get());
        }
        if (bookDto.getCategory() != null) {
            book.setCategory(bookDto.getCategory());
        }
//        if (bookDto.getBookCopies() != null) {
//            book.setBookCopies(bookDto.getBookCopies());
//        }
        if (bookDto.getName() != null) {
            book.setName(bookDto.getName());
        }
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
