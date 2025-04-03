package com.example.emtlab1a.dto;

import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.model.domain.BookCopy;

public record CreateBookCopyDto(Boolean isRented, String state, Book book) {
    public BookCopy toBookCopy() {
        return new BookCopy(isRented, state, book);
    }
}
