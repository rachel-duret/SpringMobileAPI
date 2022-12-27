package com.mobile.SpringMobileAPI.controller;

import com.mobile.SpringMobileAPI.entity.Product;
import com.mobile.SpringMobileAPI.repository.ProductRepository;
import com.mobile.SpringMobileAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/mobile")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    //    Get all product route
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

//     Create One product route
    @PostMapping("/products")
    public @ResponseBody String addOneProduct(@RequestBody Product product){
        product.setCreatedAt(new Date());
        productService.addOneProduct(product);
        return "New product added .";

    }

//    Get one product
    @GetMapping("/products/{id}")
    public Optional<Product> getOneProduct(@PathVariable int id){
        return productService.getOneProduct(id);
    }

//    Update one product
    @PutMapping("/products/{id}")
    public @ResponseBody String updateOneProduct(@RequestBody Product newProduct, @PathVariable int id){

             productService.getOneProduct(id)
                .map(product -> {
                    product.setPrice(newProduct.getPrice());
                    product.setDescription(newProduct.getDescription());
                    product.setUpdateAt(new Date());
                    return productService.addOneProduct(product);
                });
             return "Product updated .";
    }

//    Delete one product
    @DeleteMapping("/products/{id}")
    public void deleteOneProduct(@PathVariable int id){
        System.out.println(id);
        productService.deleteOneProduct(id);

    }

}




