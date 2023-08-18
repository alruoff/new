package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class MainController {
    // private UserService userService;
    @GetMapping("/")
    public String homePage() { return "home"; }
    @GetMapping("/registration")
    public String registrationPage(Principal principal) {
        return "registration: " + principal.getName();
    }
    @GetMapping("/authenticated")
    public String pageForAuthenticatedUsers(Principal principal) {
        return "secured part of web service " + principal.getName();
    }
    @GetMapping("/unsecured")
    public String usecuredPage() { return "unsecured"; }
    @GetMapping("/auth_page")
    public String authenticatedPage() {
        return "authenticated";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
//    @GetMapping("/users")
//    public String findAll(Model model){
//        List<User> usrs = userService.getAllUsers();
//        model.addAttribute("users", usrs);
//        return "user-list";
//    }
}
