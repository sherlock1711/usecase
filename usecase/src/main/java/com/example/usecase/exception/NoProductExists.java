package com.example.usecase.exception;

public class NoProductExists extends Throwable {
    public NoProductExists(String msg) {
        super(msg);
    }
}
