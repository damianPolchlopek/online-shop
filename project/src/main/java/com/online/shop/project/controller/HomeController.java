package com.online.shop.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/e")
    public String qqq(){
        return "ind";
    }


}
