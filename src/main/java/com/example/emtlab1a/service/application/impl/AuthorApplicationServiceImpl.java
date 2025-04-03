package com.example.emtlab1a.service.application.impl;

import com.example.emtlab1a.dto.CreateAuthorDto;
import com.example.emtlab1a.dto.DisplayAuthorDto;
import com.example.emtlab1a.service.application.AuthorApplicationService;
import com.example.emtlab1a.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationServiceImpl implements AuthorApplicationService {

    private final AuthorService authorService;

    public AuthorApplicationServiceImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public List<DisplayAuthorDto> findAll() {
        return DisplayAuthorDto.from(authorService.findAll());
    }

    @Override
    public Optional<DisplayAuthorDto> save(CreateAuthorDto author) {
        return authorService.save(author.toAuthor()).map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> findById(Long id) {
        return authorService.findById(id).map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto author) {
        return authorService.update(id,author.toAuthor()).map(DisplayAuthorDto::from);
    }

    @Override
    public void deleteById(Long id) {
        authorService.deleteById(id);
    }
}
