package com.mobile.SpringMobileAPI.controller;

import com.mobile.SpringMobileAPI.entity.Product;
import com.mobile.SpringMobileAPI.repository.ProductRepository;
import com.mobile.SpringMobileAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/mobile")
public class ProductController {

    @Autowired
    private ProductService productService;

//    Get all product route
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }
}
