package com.online.shop.project.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;

public class aaa {



    @Bean(name = "dataSource")
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/online_shop?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("damian");
        return ds;
    }


}
