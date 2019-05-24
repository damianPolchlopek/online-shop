package com.online.shop.project.controller;

import com.online.shop.project.entity.Product;
import com.online.shop.project.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexRest {


    private ProductService productService;

    public IndexRest(ProductService productService) {this.productService = productService;}

    @GetMapping("/")
    public String index(){

        return "Greetings from Spring Boot!";
    }

    @GetMapping("/t")
    public List<Product> test(){

        System.out.println(productService.findAll());

        return productService.findAll();
    }




    // shop category
    @GetMapping("/electronics")
    public List<Product> electronics(){

        return productService.findByCategory("Elektronika");
    }

    @GetMapping("/clothes")
    public List<Product> clothes(){

        return productService.findByCategory("Ubrania");
    }

    @GetMapping("/sport")
    public List<Product> sport(){

        return productService.findByCategory("Sport");
    }

    @GetMapping("/motorization")
    public List<Product> motorization(){

        return productService.findByCategory("Motoryzacja");
    }

    @GetMapping("/health")
    public List<Product> health(){

        return productService.findByCategory("Zdrowie");
    }







}
