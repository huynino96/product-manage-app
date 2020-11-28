package com.example.productmanage.service;

import com.example.productmanage.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> findById(int id);
    Product save(Product prd);
    void delete(int id);
}
