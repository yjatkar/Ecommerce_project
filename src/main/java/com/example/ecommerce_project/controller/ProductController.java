package com.example.ecommerce_project.controller;

import com.example.ecommerce_project.Dtos.FakeStoreProductDto;
import com.example.ecommerce_project.Exception.ProductControllerSpecificException;
import com.example.ecommerce_project.Exception.ProductNotFoundException;
import com.example.ecommerce_project.Model.Product;
import com.example.ecommerce_project.Service.FakeStoreProductService;
import com.example.ecommerce_project.Service.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//this controller supports rest api/https request i.e. if any http request comes this controller is capable of
//handling that
//request coming to /Product will ,transfer to this controller
@RequestMapping("/products")//requestmapping is endpoint of all apis in this controller
public class ProductController {
    private ProductService productService;
    ProductController(ProductService productService)
    {
        this.productService=productService;
    }
    //get single product
    @GetMapping("/{id}")//getmapping is exact address of that api
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product= productService.getProductById(id);

        //way 1 for specific controller exception(exception handler in bottom)
//        if(product==null)
//        {
//            throw new ProductControllerSpecificException("product not found");
//        }
//        return new ResponseEntity<>(product, HttpStatus.OK);

//        way2-->call productnotfound exception in controller advice
        return new ResponseEntity<>(product, HttpStatus.OK);

    }
    //get all products
    @GetMapping()
    public List<Product> getAllProducts() {

//        return new ArrayList<>();
        return productService.getAllProducts();
    }
    //create a product
    @PostMapping()
    public Product createProduct(@RequestBody Product product ) {
        return productService.createProduct(product);
    }
    //update product -->partial update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product)
    {
        return productService.updateProduct(id,product);
    }

    //replace product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){

        return productService.replaceProduct(id,product);
    }

    //delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {

    }

    //controller specific exceptions
    @ExceptionHandler(ProductControllerSpecificException.class)
    public ResponseEntity<String> handleProductControllerException(ProductControllerSpecificException exception)
    {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST

        ) ;
        //ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
