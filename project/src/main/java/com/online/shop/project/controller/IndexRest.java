package com.online.shop.project.controller;

import com.online.shop.project.entity.Product;
import com.online.shop.project.service.ProductService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexRest {

    private ProductService productService;

    public IndexRest(ProductService productService) {this.productService = productService;}


    @GetMapping("/t")
    public List<Product> test(){
        System.out.println(productService.findAll());
        return productService.findAll();
    }



    // get product by id
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.findById(id);
    }



    // shop category
    @GetMapping("/electronics")
    public List electronics(){
        return productService.findByCategory("Elektronika");
    }

    @GetMapping("/clothes")
    public List clothes(){
        return productService.findByCategory("Ubrania");
    }

    @GetMapping("/sport")
    public List sport(){
        return productService.findByCategory("Sport");
    }

    @GetMapping("/motorization")
    public List motorization(){
        return productService.findByCategory("Motoryzacja");
    }

    @GetMapping("/health")
    public List health(){
        return productService.findByCategory("Zdrowie");
    }

    @GetMapping("/other")
    public List other(){
        return productService.findByCategory("Inne");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List searchProduct(@RequestBody String myJsonString) throws JSONException {
        JSONObject json = new JSONObject(myJsonString);
        String name = json.getString("name");

        return productService.findByName(name);
    }


}
