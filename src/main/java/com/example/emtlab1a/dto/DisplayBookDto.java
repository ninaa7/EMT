package com.example.emtlab1a.dto;

import com.example.emtlab1a.model.domain.Author;
import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.model.enumerations.BookCategory;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayBookDto(Long id, String name, String category, Long author) {
    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(book.getId(), book.getName(), book.getCategory().name(), book.getAuthor().getId());
    }

    public static List<DisplayBookDto> from(List<Book> books) {
        return books.stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

}
