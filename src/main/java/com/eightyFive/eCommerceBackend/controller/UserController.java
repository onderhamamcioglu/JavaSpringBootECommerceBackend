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
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        System.out.println(user.toString());
        if (userService.getUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already registered");
        } else {
            userService.createUser(user);
            return ResponseEntity.ok("User registered successfully");
        }
    }

    @PostMapping("/login") //TODO DUMMY LOGIN METHOD
    public ResponseEntity<String> login(@RequestBody User user) {
        System.out.println(user.toString());
        if (userService.getUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.OK).body("User logged in!");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Credentials Wrong!");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
