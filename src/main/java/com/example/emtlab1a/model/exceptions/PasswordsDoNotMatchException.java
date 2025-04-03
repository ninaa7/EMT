package com.example.emtlab1a.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException {

    public PasswordsDoNotMatchException() {
        super("Passwords do not match exception.");
    }
}

