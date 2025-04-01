package com.example.emtlab1a.model;

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

    public BookCopy(Boolean isRented, String state, Book book) {
        this.isRented = true;
        this.state = state;
        this.book=book;
    }
}
