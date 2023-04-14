package com.eightyFive.eCommerceBackend.repository;

import com.eightyFive.eCommerceBackend.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> { }