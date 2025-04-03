package com.example.emtlab1a.service.domain.impl;

import com.example.emtlab1a.model.domain.Book;
import com.example.emtlab1a.model.domain.BookCopy;
import com.example.emtlab1a.model.domain.User;
import com.example.emtlab1a.model.enumerations.Role;
import com.example.emtlab1a.model.exceptions.InvalidArgumentsException;
import com.example.emtlab1a.model.exceptions.InvalidUserCredentialsException;
import com.example.emtlab1a.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.emtlab1a.model.exceptions.PasswordsDoNotMatchException;
import com.example.emtlab1a.model.exceptions.UsernameAlreadyExistsException;
import com.example.emtlab1a.repository.UserRepository;
import com.example.emtlab1a.service.domain.BookCopyService;
import com.example.emtlab1a.service.domain.BookService;
import com.example.emtlab1a.service.domain.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BookService bookService;
    private final BookCopyService bookCopyService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, BookService bookService, BookCopyService bookCopyService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.bookService = bookService;
        this.bookCopyService = bookCopyService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public List<Book> addBookToWishlist(String username, Long bookId) {
        Book book = bookService.findById(bookId).get();
        List<BookCopy> bookCopies = bookCopyService.findByBook(bookId);
        User user = findByUsername(username);
        if (!bookCopies.isEmpty() && bookCopies != null) {
            user.getWishlistedBooks().add(book);
            userRepository.save(user);
        }
        return user.getWishlistedBooks();
    }

    @Override
    public User register (
            String username,
            String password,
            String repeatPassword,
            String name,
            String surname,
            Role userRole
    ) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword)) throw new PasswordsDoNotMatchException();
        if (userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username, passwordEncoder.encode(password), name, surname, userRole);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
                InvalidUserCredentialsException::new);
    }

    @Override
    public List<Book> getUserWishlist(String username) {
        return userRepository.findByUsername(username).get().getWishlistedBooks();
    }

    @Override
    public List<BookCopy> loanWishlistedBooks(String username) {
        List<Book> books = userRepository.findByUsername(username).get().getWishlistedBooks();
        List<BookCopy> userBookCopies = new ArrayList<>();
        books.forEach(book -> {
            List<BookCopy> bookCopies = bookCopyService.findByBook(book.getId());
            if (!bookCopies.isEmpty()) {
                userBookCopies.add(bookCopies.get(0));
                bookCopyService.markAsRented(bookCopies.get(0).getId());
            }
        });
        return userBookCopies;
    }
}
