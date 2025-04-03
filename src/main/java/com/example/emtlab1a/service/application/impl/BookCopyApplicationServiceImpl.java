package com.example.emtlab1a.service.application.impl;

import com.example.emtlab1a.dto.CreateAuthorDto;
import com.example.emtlab1a.dto.CreateBookCopyDto;
import com.example.emtlab1a.dto.DisplayBookCopyDto;
import com.example.emtlab1a.dto.DisplayBookDto;
import com.example.emtlab1a.service.application.BookCopyApplicationService;
import com.example.emtlab1a.service.domain.BookCopyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookCopyApplicationServiceImpl implements BookCopyApplicationService {

    private final BookCopyService bookCopyService;

    public BookCopyApplicationServiceImpl(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @Override
    public List<DisplayBookCopyDto> findAll() {
        return bookCopyService.findAll().stream().map(DisplayBookCopyDto::from).collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayBookCopyDto> save(CreateBookCopyDto bookCopy) {
        return bookCopyService.save(bookCopy.toBookCopy()).map(DisplayBookCopyDto::from);
    }

    @Override
    public Optional<DisplayBookCopyDto> findById(Long id) {
        return bookCopyService.findById(id).map(DisplayBookCopyDto::from);
    }

    @Override
    public Optional<DisplayBookCopyDto> update(Long id, CreateBookCopyDto bookCopy) {
        return bookCopyService.update(id,bookCopy.toBookCopy()).map(DisplayBookCopyDto::from);
    }

    @Override
    public void deleteById(Long id) {
        bookCopyService.deleteById(id);
    }

    @Override
    public Optional<DisplayBookCopyDto> markAsRented(Long id) {
        return bookCopyService.markAsRented(id).map(DisplayBookCopyDto::from);
    }

    @Override
    public List<DisplayBookCopyDto> findByBook(Long id) {
        return bookCopyService.findByBook(id).stream().map(DisplayBookCopyDto::from).toList();
    }

    @Override
    public Optional<DisplayBookCopyDto> returnBook(Long id) {
        return bookCopyService.returnBook(id).map(DisplayBookCopyDto::from);
    }
    @Override
    public Optional<DisplayBookCopyDto> createCopy(Long id) {
        return bookCopyService.createCopy(id).map(DisplayBookCopyDto::from);
    }
}
