package com.example.usecase.controller;

import com.example.usecase.dto.Forgot;
import com.example.usecase.dto.Login;
import com.example.usecase.exception.UserAlreadyExist;
import com.example.usecase.exception.UserNameOrPasswordNotCorrect;
import com.example.usecase.model.Product;
import com.example.usecase.model.Response;
import com.example.usecase.model.User;
import com.example.usecase.repository.UserRepository;
import com.example.usecase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/shopping")
public class UserController {

   @Autowired
    UserService userService;

    @PostMapping("/register")
    public Response register(@RequestBody User user) throws UserAlreadyExist {
        log.info("Calling register user end point");

       return userService.register(user);

    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody Login login) throws UserNameOrPasswordNotCorrect {

        log.info("Calling login end point");
     return ResponseEntity.ok(userService.login(login));


    }

    @PostMapping("/forgot")
    public String logout(@RequestBody Forgot forgotInfo){
        log.info("calling forgot password endpoint");
        return userService.forgotPassword(forgotInfo.getEmail(), forgotInfo.getNewPassword());
    }
    @GetMapping("/role/{user}")
    public Response getProductByName(@PathVariable String user){
        return userService.findRole(user);
    }







}
