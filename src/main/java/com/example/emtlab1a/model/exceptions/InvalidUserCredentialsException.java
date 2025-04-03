package com.example.emtlab1a.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException() {
        super("Invalid user credentials exception");
    }
}

