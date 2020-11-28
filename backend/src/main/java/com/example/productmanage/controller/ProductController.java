package com.example.productmanage.controller;

import com.example.productmanage.exception.ProductNotFoundException;
import com.example.productmanage.model.Product;
import com.example.productmanage.repository.ProductRepository;
import com.example.productmanage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    List<Product> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/products/{id}")
    ResponseEntity<Product> getById(@PathVariable("id") @Min(1) int id) {
        Product prd = productService.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
        return ResponseEntity.ok().body(prd);
    }
}


