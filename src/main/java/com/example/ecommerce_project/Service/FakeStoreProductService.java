package com.example.ecommerce_project.Service;

import com.example.ecommerce_project.Dtos.FakeStoreProductDto;
import com.example.ecommerce_project.Dtos.ProductRequestDto;
import com.example.ecommerce_project.Model.Category;
import com.example.ecommerce_project.Model.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
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
        FakeStoreProductDto[] fakeStoreProductDto=restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        List<Product> products=new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDtos : fakeStoreProductDto)
        {
            products.add(fakeStoreProductDtos.toProduct());
        }
        return products;

    }
   public Product createProduct(Product product)
    {
        ProductRequestDto productRequestDto=new ProductRequestDto(product);
        FakeStoreProductDto fakeStoreProductDto=productRequestDto.toFakeStoreProductDto();
        fakeStoreProductDto=restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDto,FakeStoreProductDto.class);

        return fakeStoreProductDto.toProduct();
    }
    public Product updateProduct(){
       return null;
    }

    public Product replaceProduct(Long id,Product product){
        //convert input into correct for of request parameter
        ProductRequestDto productRequestDto=new ProductRequestDto(product);
        FakeStoreProductDto fakeStoreProductDto=productRequestDto.toFakeStoreProductDto();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        fakeStoreProductDto=restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return fakeStoreProductDto.toProduct();


    }
    public void deleteProduct(){

    }
}
