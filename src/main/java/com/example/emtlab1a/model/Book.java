package com.example.emtlab1a.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private BookCategory category;
    @ManyToOne
    private Author author;
    @OneToMany(mappedBy = "book")
    private List<BookCopy> bookCopy;

    public Book() {
    }

    public Book(String name, BookCategory category, Author author) {
        this.name = name;
        this.category = category;
        this.author = author;
    }
}
