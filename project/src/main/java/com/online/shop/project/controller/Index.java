package com.online.shop.project.controller;

import com.online.shop.project.entity.Product;
import com.online.shop.project.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Index {


    private ProductService productService;

    public Index(ProductService productService) {this.productService = productService;}

    @GetMapping("/")
    public String index(){

        return "Greetings from Spring Boot!";
    }

    @GetMapping("/t")
    public List<Product> test(){

        System.out.println(productService.findAll());

        return productService.findAll();
    }


}
