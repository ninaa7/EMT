package com.example.emtlab1a.model.domain;

import com.example.emtlab1a.model.domain.Book;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BookCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isRented;
    private String state;

    @ManyToOne
    private Book book;


    public BookCopy() {
    }
    public BookCopy(Book book) {
        this.book = book;
        this.isRented = false;
        state = " ";
    }

    public BookCopy(Boolean isRented, String state, Book book) {
        this.isRented = false;
        this.state = state;
        this.book=book;
    }
}
