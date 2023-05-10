package com.example.usecase.service.impl;

import com.example.usecase.dto.Login;
import com.example.usecase.exception.PasswordMisMatch;
import com.example.usecase.exception.UserAlreadyExist;
import com.example.usecase.exception.UserNameOrPasswordNotCorrect;
import com.example.usecase.exception.UserNotFoundException;
import com.example.usecase.model.Response;
import com.example.usecase.model.User;
import com.example.usecase.repository.UserRepository;
import com.example.usecase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public Response register(User user) throws UserAlreadyExist {
        User existUser = userRepository.findByEmail(user.getEmail());
//        System.out.println("User Already exist");

        if(existUser != null) {
            log.warn("User Arlready exists");
            return new Response("User already exist with email id");
            //throw new UserAlreadyExist("User already exist with email id");
        }


        //Check if Password and confirm password are same or not
        if(!user.getPassword().equals(user.getConfirmPassword())){
            log.warn("Password and coniirm password are not correct");
            return new Response("Confirm Password are Not same");
           //throw new PasswordMisMatch("Confirm Password are Not same");
        }

        boolean existByUserName = userRepository.existsByUserName(user.getUserName());
        if(existByUserName){
            log.warn("A user with this username already exist");
            return new Response("User Already exist with this user id");
          //  throw new UserAlreadyExist("User Already exist with this user id");
        }

        //If User not exist and password and confirm password same
        // Save the User into Database and return Successfully registerd

        log.info("New user added successfully");
        userRepository.save(user);
        return new Response("User Register Successfully");
    }

    @Override
    public Response login(Login login) throws UserNameOrPasswordNotCorrect {
//        System.out.println("login servimpl working");
        log.info("Login service working correctly");
       User user = userRepository.findByUserNameAndPassword(login.getUserName(), login.getPassword());
       if(user == null) {
//           System.out.println("Username or password are not correct");
            log.warn("Eiter UserName or Passwrod incorrect");
           throw new UserNameOrPasswordNotCorrect("Either username or password incorrect");
       }
        log.info("Login successful");


        return new Response("Login Succesful");
    }

    @Override
    public String forgotPassword(String email, String newPassword) throws UserNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            log.warn("Emali is incorrect");
            throw  new UserNotFoundException("Email id is incorrect");
        }
        user.setPassword(newPassword);
        log.info("Password change successful");
        userRepository.save(user);
        return "Your Password has reset Successfully";
    }
    @Override
    public Response findRole(String username) throws UserNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        if(user == null){
            log.warn("Emali is incorrect");
            throw  new UserNotFoundException("Email id is incorrect");
        }
        User u=user.get();


        return new Response(u.getRole()) ;
    }
}
