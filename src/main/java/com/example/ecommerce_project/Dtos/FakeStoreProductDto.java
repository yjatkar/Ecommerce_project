package com.example.ecommerce_project.Dtos;

import com.example.ecommerce_project.Model.Category;
import com.example.ecommerce_project.Model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductDto {
    private long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
    @Override
    public String toString() {
        return "FakeStoreProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
    public Product toProduct()
    {
        Product product=new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setPrice(this.price);
        product.setDescription(this.description);
        product.setImage(this.image);
        Category category=new Category();
        category.setTitle(this.category);
        product.setCategory(category);
        return product;
    }
}
