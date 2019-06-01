package com.online.shop.project.service;

import com.online.shop.project.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    List findByCategory(String category);

    Product findById(int theId);

    void save(Product theWord);

    void deleteById(int theId);

    List findByName(String name);

}
