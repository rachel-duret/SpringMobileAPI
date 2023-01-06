package com.mobile.SpringMobileAPI.repository;

import com.mobile.SpringMobileAPI.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    Boolean existsByModel(String model);
}
