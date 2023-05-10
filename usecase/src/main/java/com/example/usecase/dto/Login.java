package com.example.usecase.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data

public class Login {
    private String userName;
    private String password;
}
