package com.example.ecommerce_project.Service;

import com.example.ecommerce_project.Dtos.FakeStoreProductDto;
import com.example.ecommerce_project.Model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }

   public Product getProductById(Long id)
    {
        //convert fakeStoreProductDto to product object
        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        System.out.println("FakeStore Response DTO: " + fakeStoreProductDto);

        if(fakeStoreProductDto==null)
        {
            return null;
        }
        return fakeStoreProductDto.toProduct();
    }
    public List<Product> getAllProducts(){
        FakeStoreProductDto[] fakeStoreProductDto=restTemplate.getForObject("https://fakestoreapi.com/products/",FakeStoreProductDto[].class);

        List<Product> products=new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDtos : fakeStoreProductDto)
        {
            products.add(fakeStoreProductDtos.toProduct());
        }
        return products;

    }
   public Product createProduct()
    {
        return null;
    }
    public Product updateProduct(){
       return null;
    }
    public Product replaceProduct(){
       return null;
    }
    public void deleteProduct(){

    }
}
