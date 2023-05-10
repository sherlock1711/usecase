package com.example.usecase.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value
            = ProductNotFound.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handleException(ProductNotFound ex){
        log.info("Product not found exception handler working");
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = UserAlreadyExist.class)
    public @ResponseBody ErrorResponse handleException(UserAlreadyExist ex){
        log.info("User already exist  exception handler working");
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }

    @ExceptionHandler(value = PasswordMisMatch.class)
    public @ResponseBody ErrorResponse handleException(PasswordMisMatch ex){
        log.info("Password mismatch exception handler working");
        return new ErrorResponse(HttpStatus.EXPECTATION_FAILED.value(), ex.getMessage());
    }

    @ExceptionHandler(value = UserNameOrPasswordNotCorrect.class)
    public @ResponseBody ErrorResponse handleException(UserNameOrPasswordNotCorrect ex){
        log.warn("User name or Password not correct exception handler working");
        return new ErrorResponse(HttpStatus.FORBIDDEN.value(), ex.getMessage());
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public @ResponseBody ErrorResponse handleException(UserNotFoundException ex){
        log.info("User not found exception handler working");
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
