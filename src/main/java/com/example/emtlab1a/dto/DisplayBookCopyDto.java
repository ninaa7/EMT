package com.example.emtlab1a.dto;

import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.model.domain.BookCopy;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayBookCopyDto(Long id, Boolean isRented, String state, Long book) {
    public static DisplayBookCopyDto from(BookCopy bookCopy) {
        return new DisplayBookCopyDto(bookCopy.getId(), bookCopy.getIsRented(), bookCopy.getState(), bookCopy.getBook().getId());
    }

    public static List<DisplayBookCopyDto> from(List<BookCopy> bookCopys) {
        return bookCopys.stream().map(DisplayBookCopyDto::from).collect(Collectors.toList());
    }

}
