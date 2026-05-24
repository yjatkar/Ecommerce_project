package com.example.ecommerce_project.Service;

import com.example.ecommerce_project.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service//to create object of product service class
public class ProductService {
    //here we will call fakestore api to get product data

    public Product getProductById(@PathVariable("id") Long id) {
        return new Product();
    }
}
