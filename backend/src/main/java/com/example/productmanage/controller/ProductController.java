package com.example.productmanage.controller;

import com.example.productmanage.dto.ProductDTO;
import com.example.productmanage.exception.ProductNotFoundException;
import com.example.productmanage.mapper.ProductMapper;
import com.example.productmanage.model.Product;
import com.example.productmanage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get All Products
    @GetMapping(value = "/products")
    List<Product> getAll(){
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping(value = "/products/{id}")
    ResponseEntity<Product> getById(@PathVariable("id") @Min(1) int id) {
        Product prd = productService.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
        return ResponseEntity.ok().body(prd);
    }

    // Post new Product
    @PostMapping(value="/products")
    ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO inprod) {
        Product prd      = ProductMapper.DtoToEntity(inprod);
        Product addedProduct = productService.save(prd);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedProduct.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // Update product details PUT /api/products/{id}
    @PutMapping(value="/products/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable("id")  @Min(1) int id, @Valid @RequestBody ProductDTO inprod) {
        Product prd = productService.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));

        Product newProduct = ProductMapper.DtoToEntity(inprod);
        newProduct.setId(prd.getId());
        productService.save(newProduct);
        return ResponseEntity.ok().body(newProduct);
    }

    // Delete product by ID DELETE /api/products/{id}
    @DeleteMapping(value="/products/{id}")
    ResponseEntity deleteProduct( @PathVariable("id") @Min(1) int id) {
        Product prd = productService.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
        productService.delete(prd.getId());
        return ResponseEntity.ok().body("Product with ID : "+id+" deleted with success!");
    }




}


