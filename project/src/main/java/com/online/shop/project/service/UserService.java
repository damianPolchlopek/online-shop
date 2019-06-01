package com.online.shop.project.service;

import com.online.shop.project.entity.User;


public interface UserService {

//    List<User> findAll();

    void save(User user);

    User findByName(String name);

}
