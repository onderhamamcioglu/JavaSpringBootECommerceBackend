package com.eightyFive.eCommerceBackend.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@ToString
@Data
public class User implements UserDetails {
    @NonNull
    protected String username;

    @NonNull
    protected String password;

    @NonNull
    protected String email;

    @Enumerated(EnumType.STRING)
    @NonNull
    protected Role role;

    User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.CUSTOMER;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
