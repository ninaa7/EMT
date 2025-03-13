package com.example.emtlab1a.model.dto;

import com.example.emtlab1a.model.Author;
import com.example.emtlab1a.model.BookCategory;
import lombok.Data;

@Data
public class BookDto {
    private String name;
    private BookCategory category;
    private Long author;
    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, BookCategory category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
