package com.example.usecase.exception;

public class UserNameOrPasswordNotCorrect extends Throwable {
    public UserNameOrPasswordNotCorrect(String msg) {
        super(msg);
    }
}
