package com.example.ecommerce_project.Service;

import com.example.ecommerce_project.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct();
    Product updateProduct();
    Product replaceProduct();
    void deleteProduct();

}
