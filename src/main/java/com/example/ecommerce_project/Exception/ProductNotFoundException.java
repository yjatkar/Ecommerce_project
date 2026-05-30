package com.example.ecommerce_project.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
@Setter
public class ProductNotFoundException extends RuntimeException{
    private long id;
    public ProductNotFoundException(Long id,String message)
    {
        super(message);
        this.id=id;
    }
}
