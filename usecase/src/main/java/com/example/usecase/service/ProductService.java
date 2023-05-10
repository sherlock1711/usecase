package com.example.usecase.service;


import com.example.usecase.exception.NoProductExists;
import com.example.usecase.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct() throws NoProductExists;

    List<Product> searchByProductName(String name);

    Product addProduct(Product product);

    String productStatus(String id);

    String deleteProduct(String id);
}
