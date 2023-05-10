package com.example.usecase.controller;

import com.example.usecase.exception.NoProductExists;
import com.example.usecase.model.Product;
import com.example.usecase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/shopping")
public class ProductController {

    @Autowired
    ProductService productService;
    @CrossOrigin
    @GetMapping("/all")
    public List<Product> getAllProducts() throws NoProductExists {
        return productService.getAllProduct();
    }

    @GetMapping("/products/search/{productName}")
    public List<Product> getProductByName(@PathVariable String productName){
       return productService.searchByProductName(productName);
    }

    @PostMapping("/add")
    public Product addNewProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/update/{id}")
    public String updateProductStatus(@PathVariable String id){
        return productService.productStatus(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }
}
