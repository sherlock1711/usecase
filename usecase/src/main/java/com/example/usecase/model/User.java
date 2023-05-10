package com.example.usecase.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;

//    @NotNull
    private String firstName;

//    @NotNull
    private String lastName;


//    @NotNull
    private String email;

//    @NotNull
    private String userName;

//    @NotNull

    private String password;
//    @NotNull
    @Transient
    private String confirmPassword;

//    @NotNull
    private String contactNumber;

    private String role;


}
