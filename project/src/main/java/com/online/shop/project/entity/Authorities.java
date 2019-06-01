package com.online.shop.project.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @Column(name="username")
    private String username;


    @Column(name="authority")
    private String authority;




}
