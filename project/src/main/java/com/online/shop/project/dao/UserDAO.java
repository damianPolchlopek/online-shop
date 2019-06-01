package com.online.shop.project.dao;

import com.online.shop.project.entity.User;

import java.util.List;

public interface UserDAO {

    void save(User user);

    User findByName(String name);

}
