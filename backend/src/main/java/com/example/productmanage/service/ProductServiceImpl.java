package com.example.productmanage.service;

import com.example.productmanage.model.Product;
import com.example.productmanage.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        return productRepository.findAll();
    }
    @Override
    public Optional<Product> findById(int id) {
        // TODO Auto-generated method stub
        return productRepository.findById(id);
    }
    @Override
    public Product save(Product prd) {
        // TODO Auto-generated method stub
        return productRepository.save(prd);
    }
    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        productRepository.deleteById(id);
    }
}

