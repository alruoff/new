package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.User;
import com.example.demo.services.CustomerService;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping ("/newcustomer")
    public ResponseEntity createNewCustomer(@RequestParam(name="fullname") String fullname,
                                            @RequestParam(name="login") String login,
                                            @RequestParam(name="email") String email,
                                            @RequestParam(name="role") String role ) {

       // User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));

        customerService.createNewCustomer(fullname, login ,email, role);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
