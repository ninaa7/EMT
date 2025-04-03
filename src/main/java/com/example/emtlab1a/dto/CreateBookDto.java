package com.example.emtlab1a.dto;

import com.example.emtlab1a.model.domain.Author;
import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.model.enumerations.BookCategory;

public record CreateBookDto(String name, BookCategory category, Author author) {
    public Book toBook(BookCategory category1, Author author1) {
        return new Book(name, category1 ,author1);
    }
}
