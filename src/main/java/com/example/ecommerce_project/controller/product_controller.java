package com.example.ecommerce_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//this controoler supports rest api/https request i.e. if any http request comes this controller is capable of
//handling that
//request coming to /Product will ,transfer to this controller
@RequestMapping("/Product")//requestmapping is endpoint of all apis in this controller
public class product_controller {
    @GetMapping("/{name}/{city}")//getmapping is exact address of that api
    public String sayHello(@PathVariable("name") String name,@PathVariable("city") String city) {
        return "hello "+name+" is present in "+city;
    }
}
