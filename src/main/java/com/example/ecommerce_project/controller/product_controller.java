package com.example.ecommerce_project.controller;

import com.example.ecommerce_project.Model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//this controller supports rest api/https request i.e. if any http request comes this controller is capable of
//handling that
//request coming to /Product will ,transfer to this controller
@RequestMapping("/products")//requestmapping is endpoint of all apis in this controller
public class product_controller {
    //get single product
    @GetMapping("/{id}")//getmapping is exact address of that api
    public Product getProductById(@PathVariable("id") Long id) {
        return new Product();
    }
    //get all products
    @GetMapping()
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }
    //create a product
    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return new Product();
    }
    //update product -->partial update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product)
    {
        return new Product();
    }

    //replace product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product)
    {
        return new Product();
    }

    //delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {

    }
}
