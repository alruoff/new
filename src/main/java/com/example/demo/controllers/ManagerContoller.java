package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ManagerContoller {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/view")
    public String viewTestPage(Principal principal) {
        // Authentication a = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));
        return "authenticated: " + user.getUsername() + " : " + user.getEmail();
    }
}
