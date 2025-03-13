package com.example.emtlab1a.config;

import com.example.emtlab1a.model.Author;
import com.example.emtlab1a.model.Book;
import com.example.emtlab1a.model.BookCategory;
import com.example.emtlab1a.model.Country;
import com.example.emtlab1a.repository.AuthorRepository;
import com.example.emtlab1a.repository.BookRepository;
import com.example.emtlab1a.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }
    @PostConstruct
    public void init(){
        Country country1 = countryRepository.save(new Country("Country1", "Continent1"));
        Country country2 = countryRepository.save(new Country("Country2", "Continent2"));

        Author author1=authorRepository.save(new Author("Name1","Surname1",country1));
        Author author2=authorRepository.save(new Author("Name2","Surname2",country2));

        bookRepository.save(new Book("Book1", BookCategory.DRAMA,author1,5));
        bookRepository.save(new Book("Book1", BookCategory.HISTORY,author2,3));

    }
}
