package com.example.emtlab1a.service.application;

import com.example.emtlab1a.dto.CreateAuthorDto;
import com.example.emtlab1a.dto.DisplayAuthorDto;
import com.example.emtlab1a.model.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    List<DisplayAuthorDto> findAll();
    Optional<DisplayAuthorDto> save(CreateAuthorDto author);

    Optional<DisplayAuthorDto> findById(Long id);

    Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto author);

    void deleteById(Long id);
}
