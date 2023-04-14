package com.eightyFive.eCommerceBackend.controller;

import com.eightyFive.eCommerceBackend.model.Customer;
import com.eightyFive.eCommerceBackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        System.out.println(customer.toString());
        if (customerService.getCustomerByUsername(customer.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already registered");
        } else {
            customerService.createCustomer(customer);
            return ResponseEntity.ok("User registered successfully");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String username) {
        Customer customer = customerService.getCustomerByUsername(username);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
