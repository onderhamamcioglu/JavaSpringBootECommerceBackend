package com.eightyFive.eCommerceBackend.repository;

import com.eightyFive.eCommerceBackend.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> { }