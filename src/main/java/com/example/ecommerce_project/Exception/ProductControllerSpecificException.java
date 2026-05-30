package com.example.ecommerce_project.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductControllerSpecificException extends RuntimeException{
   public  ProductControllerSpecificException(String message)
    {
        super(message);
    }
}
