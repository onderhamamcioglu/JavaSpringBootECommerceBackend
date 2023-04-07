package com.eightyFive.eCommerceBackend.repository;

import com.eightyFive.eCommerceBackend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}