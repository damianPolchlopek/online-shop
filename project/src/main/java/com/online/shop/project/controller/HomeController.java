package com.online.shop.project.controller;

import com.online.shop.project.dto.RegisteredUser;
import com.online.shop.project.entity.Authorities;
import com.online.shop.project.entity.User;
import com.online.shop.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/main";
    }


    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/addPerson")
    public String register(Model model){
        model.addAttribute("user", new RegisteredUser());
        return "add-person";
    }

    @PostMapping("/verifyRegisterData")
    public String checkData(@ModelAttribute("user") RegisteredUser registeredUser){

        System.out.println("John: " + userService.findByName("john"));
        System.out.println("Registered: " + registeredUser);

        if (!checkIfTwoPasswordIsTheSame(registeredUser)){
            System.out.println("Rozne hasla");
            return "redirect:/main";
        }

//        if (!checkIfUsernameIsFree(registeredUser)){
//            System.out.println("Zajety username");
//            return "main";
//        }

        User user = new User();
        user.setUsername(registeredUser.getUsername());
        user.setPassword("{noop}" + registeredUser.getFirstPassword());
        user.setEnabled(1);

        Authorities auth1 = new Authorities();
        auth1.setUsername(registeredUser.getUsername());
        auth1.setAuthority("ROLE_EMPLOYEE");
        List<Authorities> authorities = new ArrayList<>();
        authorities.add(auth1);
        user.setAuthorities(authorities);

        userService.save(user);
        System.out.println("Zapisalem dane");

        return "redirect:/main";
    }

    private boolean checkIfTwoPasswordIsTheSame(RegisteredUser registeredUser) {
        return registeredUser.getFirstPassword().equals(registeredUser.getSecondPassword());
    }

//    private boolean checkIfUsernameIsFree(RegisteredUser registeredUser) {
//
//        System.out.println("Sprawdzenie czy uzytkownik istnieje: " + userService.findByName(registeredUser.getUsername()) != null);
//
//        return userService.findByName(registeredUser.getUsername()) != null;
//    }

}
