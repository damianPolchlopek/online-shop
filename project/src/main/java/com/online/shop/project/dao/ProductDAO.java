package com.online.shop.project.dao;


import com.online.shop.project.entity.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> findAll();

    Product findById(int theId);

    void save(Product theWord);

    void deleteById(int theId);

    List findByCategory(String category);
}
