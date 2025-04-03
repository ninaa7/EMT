package com.example.emtlab1a.service.domain.impl;

import com.example.emtlab1a.model.domain.Author;
import com.example.emtlab1a.repository.AuthorRepository;
import com.example.emtlab1a.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(Author author) {
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> findById(Long Id) {
        return this.authorRepository.findById(Id);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository.findById(id).map(existingAuthor -> {
            if (author.getName() != null) {
                existingAuthor.setName(author.getName());
            }
            if (author.getSurname() != null) {
                existingAuthor.setSurname(author.getSurname());
            }
            if (author.getCountry() != null) {
                existingAuthor.setCountry(author.getCountry());
            }
            return authorRepository.save(existingAuthor);
        });
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
