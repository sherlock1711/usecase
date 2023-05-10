package com.example.usecase.service;

import com.example.usecase.dto.Login;
import com.example.usecase.exception.UserAlreadyExist;
import com.example.usecase.exception.UserNameOrPasswordNotCorrect;
import com.example.usecase.model.Response;
import com.example.usecase.model.User;

public interface UserService {

    public Response register(User user) throws UserAlreadyExist;

    public Response login(Login login) throws UserNameOrPasswordNotCorrect;

    public String forgotPassword(String email, String newPassword);
    public Response findRole(String username);

}
