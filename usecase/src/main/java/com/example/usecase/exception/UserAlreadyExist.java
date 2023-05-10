package com.example.usecase.exception;

public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist(String s) {
        super(s);
    }
}
