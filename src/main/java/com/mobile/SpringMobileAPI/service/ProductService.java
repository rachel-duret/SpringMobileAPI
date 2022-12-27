package com.mobile.SpringMobileAPI.service;

import com.mobile.SpringMobileAPI.entity.Product;
import com.mobile.SpringMobileAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product addOneProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getOneProduct(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteOneProduct(int id) {
         productRepository.deleteById(id);
    }
}
