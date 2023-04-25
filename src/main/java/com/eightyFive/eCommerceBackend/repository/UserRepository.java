package com.eightyFive.eCommerceBackend.repository;

import com.eightyFive.eCommerceBackend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> { //extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}