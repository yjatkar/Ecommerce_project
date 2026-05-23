package com.example.ecommerce_project.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //as we are using lombok we can directly implement getter and setter
public class Product {
    private long id;
    private String title;
    private String price;
    private  Category category;
    private String description;
    private String image;

}
