package com.example.usecase.model;

import lombok.Data;

@Data
public class Response {
    public Response(String message) {
        this.message = message;
    }

    private String message;

}
