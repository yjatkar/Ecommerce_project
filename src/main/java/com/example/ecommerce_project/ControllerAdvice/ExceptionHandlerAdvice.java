package com.example.ecommerce_project.ControllerAdvice;

import com.example.ecommerce_project.Dtos.ArithmeticExceptionDto;
import com.example.ecommerce_project.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(){
        ArithmeticExceptionDto dto=new ArithmeticExceptionDto();
        dto.setMessage("somehting went wrong");
        dto.setDetail("arithemtic somethign wrong");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public void handleArrayIndexOutOfBoundException(){

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception)
    {
        return new ResponseEntity<>(
                exception.getMessage()+" "+exception.getId(),
                HttpStatus.NOT_FOUND
        );
    }
}
