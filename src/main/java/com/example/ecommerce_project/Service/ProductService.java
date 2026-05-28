package com.example.ecommerce_project.Service;

import com.example.ecommerce_project.Dtos.FakeStoreProductDto;
import com.example.ecommerce_project.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    public Product createProduct(Product product);
    Product updateProduct(Long id,Product product);
    Product replaceProduct(Long id,Product product);
    void deleteProduct();

}
