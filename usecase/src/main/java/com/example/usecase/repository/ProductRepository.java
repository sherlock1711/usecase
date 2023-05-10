package com.example.usecase.repository;

import com.example.usecase.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByProductName(String name);
    @Query("{ 'productName' : { $regex: ?0 } }")
    List<Product> findByRegex(String regexp);

//    boolean existById(String id);
}
