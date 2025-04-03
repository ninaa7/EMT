package com.example.emtlab1a.service.application.impl;

import com.example.emtlab1a.dto.*;
import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.model.domain.User;
import com.example.emtlab1a.service.application.UserApplicationService;
import com.example.emtlab1a.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;

    public UserApplicationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));
    }

    @Override
    public Optional<DisplayUserDto> login(LoginUserDto loginUserDto) {
        return Optional.of(DisplayUserDto.from(userService.login(
                loginUserDto.username(),
                loginUserDto.password()
        )));
    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }

    @Override
    public List<DisplayBookDto> addBookToWhishlist(String username, Long bookId) {
        User user = userService.findByUsername(username);
        userService.addBookToWishlist(username,bookId);
        List<Book> books = user.getWishlistedBooks();
        return books.stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

    @Override
    public List<DisplayBookDto> getUserWishlist(String username) {
        return userService.getUserWishlist(username).stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

    @Override
    public List<DisplayBookCopyDto> loanWishlistedBooks(String username) {
        return userService.loanWishlistedBooks(username).stream().map(DisplayBookCopyDto::from).collect(Collectors.toList());

    }

}
