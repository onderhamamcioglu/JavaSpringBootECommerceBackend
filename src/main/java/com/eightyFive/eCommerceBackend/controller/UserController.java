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
    private PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userService.createUser(user) == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exits!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(jwtService.generateToken(user));
    }

    @PostMapping("/login") //TODO DUMMY LOGIN METHOD
    public ResponseEntity<String> login(@RequestBody User user) {
        /*
        System.out.println(user.toString());
        if (userService.getUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.OK).body("User logged in!");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Credentials Wrong!");
        }
         */

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        if(userService.getUserByUsername(user.getUsername()) == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Credentials Wrong!");
        } //TODO Swtich this to var user = repository.findByEmail(request.getEmail()).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(jwtService.generateToken(user));
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
