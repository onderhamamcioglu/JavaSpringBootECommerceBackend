package com.eightyFive.eCommerceBackend.model;

import lombok.*;

@Data
@ToString
public class Admin extends User{
    public Admin(String username, String password, String email) {
        super(username, password, email);
    }
}