package com.mobile.SpringMobileAPI.service;

import com.mobile.SpringMobileAPI.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {
    public List<Product> getAllProduct();
    public Product addOneProduct(Product product);

    public Optional<Product> getOneProduct(int id);

    public void deleteOneProduct(int id);


}
