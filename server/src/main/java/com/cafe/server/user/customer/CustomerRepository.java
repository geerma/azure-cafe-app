package com.cafe.server.user.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT u FROM CafeUser u WHERE u.username = ?1")
    Optional<Customer> findByUsername(String username);

}