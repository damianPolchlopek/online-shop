package com.online.shop.project.service;

import com.online.shop.project.dao.ProductDAO;
import com.online.shop.project.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    @Transactional
    public Product findById(int theId) {
        return productDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Product theProduct) {
        productDAO.save(theProduct);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        productDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public List<Product> findByCategory(String category) {
        return productDAO.findByCategory(category);
    }



}
