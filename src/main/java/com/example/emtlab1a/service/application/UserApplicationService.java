package com.example.emtlab1a.service.application;

import com.example.emtlab1a.dto.*;

import java.util.List;
import java.util.Optional;

public interface UserApplicationService {
    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
    List<DisplayBookDto> addBookToWhishlist(String username, Long bookId);
    List<DisplayBookDto> getUserWishlist(String username);
    List<DisplayBookCopyDto> loanWishlistedBooks(String username);


}
