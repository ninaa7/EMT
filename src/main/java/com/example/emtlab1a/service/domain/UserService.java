package com.example.emtlab1a.service.domain;

import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.model.domain.BookCopy;
import com.example.emtlab1a.model.domain.User;
import com.example.emtlab1a.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);
    List<Book> addBookToWishlist (String username, Long id);
    List<Book> getUserWishlist(String username);
    List<BookCopy> loanWishlistedBooks(String username);
}

