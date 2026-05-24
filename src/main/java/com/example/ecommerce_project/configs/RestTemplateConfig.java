package com.example.ecommerce_project.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate(){
//       RestTemplate restTemplate=new RestTemplate();
//        return restTemplate;
        return new RestTemplateBuilder().build();
    }


}


