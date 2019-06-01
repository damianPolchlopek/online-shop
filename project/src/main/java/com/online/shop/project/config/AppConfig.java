package com.online.shop.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@EnableSpringDataWebSupport
@Import({ SecurityConfig.class, WebConfig.class })
public class AppConfig {



//    @Bean(name = "dataSource")
//    public BasicDataSource dataSource() {
//        BasicDataSource ds = new BasicDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/online_shop?useSSL=false");
//        ds.setUsername("root");
//        ds.setPassword("damian");
//        return ds;
//    }


}
