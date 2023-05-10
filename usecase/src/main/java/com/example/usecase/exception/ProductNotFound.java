package com.example.usecase.exception;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String msg){
        super(msg);
    }
}
