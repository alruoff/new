package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import com.example.demo.entities.exceptiopns.LoginUniqException;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final UserService userService;
    private final CustomerRepository customerRepository;
    private final RoleService roleService;

    public Customer createNewCustomer(String fullName, String login, String email, String roleString) {

        if (userService.findByUsername(login).isPresent() == true) {

            try { // выбрасываем Exception
                throw new LoginUniqException("введённый логин пользователя должен быть уникальным");
            } catch (LoginUniqException e) {
                throw new RuntimeException(e);
            }

        } else { //только, если логин уникален

            BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

            Role role = roleService.getUserRole("ROLE_" + roleString);

            User user = new User(login, pe.encode(login), Arrays.asList(role));

            Customer customer = new Customer(fullName, false, LocalDateTime.now(), LocalDateTime.now(), email, role.getName(), user);

            userService.saveUser(user);

            return customer;
        }

    }

}
