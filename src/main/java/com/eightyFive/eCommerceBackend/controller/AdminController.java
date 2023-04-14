package com.eightyFive.eCommerceBackend.controller;

import com.eightyFive.eCommerceBackend.model.Admin;
import com.eightyFive.eCommerceBackend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @GetMapping("/{username}")
    public ResponseEntity<Admin> getUserByUsername(@PathVariable String username) {
        Admin admin = adminService.getAdminByUsername(username);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
