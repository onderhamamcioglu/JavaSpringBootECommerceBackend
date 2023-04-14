package com.eightyFive.eCommerceBackend.service;

import com.eightyFive.eCommerceBackend.configuration.UserConfiguration;
import com.eightyFive.eCommerceBackend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    @Autowired
    private final UserConfiguration userConfiguration;

    public CustomerService(UserConfiguration userConfiguration) {
        this.userConfiguration = userConfiguration;
    }

    public Customer createCustomer(Customer customer){
        customers.add(customer);
        userConfiguration.increaseCounter();
        System.out.println(userConfiguration.counter);
        return customer;
    }

    public Customer getCustomerByUsername(String username) {
        return customers.stream()
                .filter(customer -> customer.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

}
