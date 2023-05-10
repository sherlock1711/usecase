package com.example.usecase.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Forgot {
    private String email;
    private String newPassword;
}
