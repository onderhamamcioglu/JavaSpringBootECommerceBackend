package com.eightyFive.eCommerceBackend.service;

import com.eightyFive.eCommerceBackend.model.Role;
import com.eightyFive.eCommerceBackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private List<User> users = new ArrayList<>();

    public User createUser(User user){ //TODO Implement repository, DB etc.
        if(getUserByUsername(user.getUsername()) != null){
            return null;
        }
        user.setRole(Role.USER);
        users.add(user);
        return user;
    }

    public User getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByUsername(username);
    }
}
