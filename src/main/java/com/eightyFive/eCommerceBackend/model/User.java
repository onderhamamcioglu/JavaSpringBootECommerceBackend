package com.eightyFive.eCommerceBackend.model;

import lombok.*;


@Data
public class User {
    @NonNull
    protected String username;

    @NonNull
    protected String password;

    @NonNull
    protected String email;

    User(){}

    User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
