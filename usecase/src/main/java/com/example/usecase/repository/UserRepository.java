package com.example.usecase.repository;

import com.example.usecase.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);


    Optional<User> findByUserName(String userName);

    boolean existsByEmail(String email);

    User findByUserNameAndPassword(String userName, String password);

    boolean existsByUserName(String userName);
}
