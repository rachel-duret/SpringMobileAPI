package com.mobile.SpringMobileAPI.service;

import com.mobile.SpringMobileAPI.entity.Product;
import com.mobile.SpringMobileAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }





}
