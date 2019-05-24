package com.online.shop.project.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

//    // baza danych uzytkownikow zahardcodowana tutaj
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth
//            .inMemoryAuthentication()
//            .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//            .withUser(users.username("damian").password("test123").roles("EMPLOYEE"))
//            .withUser(users.username("a").password("a").roles("EMPLOYEE"));
//
//
//    }
//
    // baza danych uzytkownikow w postaci mysql
    @Autowired
    private DataSource dataSource;


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();


        http.authorizeRequests()
                .antMatchers("/**").hasRole("EMPLOYEE")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
////                .loginPage("/login/showPlainForm")
////                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");



    }



}