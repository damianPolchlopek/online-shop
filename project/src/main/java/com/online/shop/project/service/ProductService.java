package com.online.shop.project.service;

import com.online.shop.project.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product findById(int theId);

    public void save(Product theWord);

    public void deleteById(int theId);

}
