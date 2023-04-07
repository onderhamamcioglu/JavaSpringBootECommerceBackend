package com.eightyFive.eCommerceBackend.controller;

import com.eightyFive.eCommerceBackend.model.User;
import com.eightyFive.eCommerceBackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/register") //CREATE
    public ResponseEntity<User> register(@RequestBody User user) {
        User newUser = userService.createUser(user);
        System.out.println(user.toString());
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
