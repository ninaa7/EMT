package com.example.emtlab1a.config;

import com.example.emtlab1a.model.*;
import com.example.emtlab1a.repository.AuthorRepository;
import com.example.emtlab1a.repository.BookCopyRepository;
import com.example.emtlab1a.repository.BookRepository;
import com.example.emtlab1a.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    private final BookCopyRepository bookCopyRepository;

    public DataInitializer(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository, BookCopyRepository bookCopyRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
        this.bookCopyRepository = bookCopyRepository;
    }
    @PostConstruct
    public void init(){
        Country country1 = countryRepository.save(new Country("Country1", "Continent1"));
        Country country2 = countryRepository.save(new Country("Country2", "Continent2"));

        Author author1=authorRepository.save(new Author("Name1","Surname1",country1));
        Author author2=authorRepository.save(new Author("Name2","Surname2",country2));

         Book book1 = bookRepository.save(new Book("Book1", BookCategory.DRAMA,author1));
         Book book2 = bookRepository.save(new Book("Book1", BookCategory.HISTORY,author2));

        BookCopy bookCopy1 = bookCopyRepository.save(new BookCopy(true,"Good state", book1));
        BookCopy bookCopy2 = bookCopyRepository.save(new BookCopy(true, "Medium state",book2));

    }
}
