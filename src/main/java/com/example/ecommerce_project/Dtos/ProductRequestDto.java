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
        if(this.description!=null){
            fakeStoreProductDto.setDescription(this.description);
        }
        if(this.title!=null){
            fakeStoreProductDto.setTitle(this.title);
        }
        if(this.price!=null){
            fakeStoreProductDto.setPrice(this.price);
        }
        if(this.image!=null)
        {
            fakeStoreProductDto.setImage(this.image);
        }
        if(this.category!=null)
        {
            fakeStoreProductDto.setCategory(this.category.getTitle());
        }

        return fakeStoreProductDto;

    }
}
