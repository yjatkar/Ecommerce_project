package com.example.ecommerce_project.Dtos;

import com.example.ecommerce_project.Model.Category;
import com.example.ecommerce_project.Model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private long id;
    private String title;
    private Double price;
    private Category category;
    private String description;
    private String image;
    public ProductRequestDto(Product product)
    {
        this.id= product.getId();
        this.title=product.getTitle();
        this.price=product.getPrice();
        this.category=product.getCategory();
        this.description=product.getDescription();
        this.image=product.getImage();
    }

    public FakeStoreProductDto toFakeStoreProductDto(){
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(this.description);
        fakeStoreProductDto.setTitle(this.title);
        fakeStoreProductDto.setPrice(this.price);
        fakeStoreProductDto.setImage(this.image);
        fakeStoreProductDto.setCategory(this.category.getTitle());
        return fakeStoreProductDto;

    }
}
