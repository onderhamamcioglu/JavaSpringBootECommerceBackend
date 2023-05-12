package com.eightyFive.eCommerceBackend.controller;

import com.eightyFive.eCommerceBackend.model.User;
import com.eightyFive.eCommerceBackend.service.JwtService;
import com.eightyFive.eCommerceBackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userService.createUser(user) == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exits!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(jwtService.generateToken(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        /*
        System.out.println(user.toString());
        if (userService.getUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.OK).body("User logged in!");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Credentials Wrong!");
        }
         */

        System.out.println(user.toString());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        return ResponseEntity.status(HttpStatus.OK).body(jwtService.generateToken(user));
    }


}
