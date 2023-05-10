package com.example.usecase.exception;

public class PasswordMisMatch extends RuntimeException {
    public PasswordMisMatch(String msg) {
        super(msg);
    }
}