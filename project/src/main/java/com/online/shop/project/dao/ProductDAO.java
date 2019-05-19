package com.online.shop.project.dao;


import com.online.shop.project.entity.Product;

import java.util.List;

public interface ProductDAO {

    public List<Product> findAll();

    public Product findById(int theId);

    public void save(Product theWord);

    public void deleteById(int theId);

}
