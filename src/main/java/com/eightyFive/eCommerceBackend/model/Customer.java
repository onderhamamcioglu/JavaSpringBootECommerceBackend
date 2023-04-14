package com.eightyFive.eCommerceBackend.model;

import lombok.*;

@Data
public class Customer extends User{

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String address;

    Customer(String username, String password, String email) {
        super(username, password, email);
    }
}