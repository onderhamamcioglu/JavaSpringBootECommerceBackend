package com.eightyFive.eCommerceBackend.service;

import com.eightyFive.eCommerceBackend.configuration.UserConfiguration;
import com.eightyFive.eCommerceBackend.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    private List<Admin> admins = new ArrayList<>();
    Admin defaultAdmin = new Admin("defaultAdmin","P4ssw0rd!","defaultadmin@system.com");

    @Autowired
    private final UserConfiguration userConfiguration;

    AdminService(UserConfiguration userConfiguration){
        this.userConfiguration = userConfiguration;
        createAdmin(defaultAdmin);
    }

    public Admin createAdmin(Admin admin){
        admins.add(admin);
        userConfiguration.increaseCounter();
        System.out.println(userConfiguration.counter);
        return admin;
    }

    public Admin getAdminByUsername(String username) {
        System.out.println(userConfiguration.counter);
        return admins.stream()
                .filter(customer -> customer.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
