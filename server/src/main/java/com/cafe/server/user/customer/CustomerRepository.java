package com.cafe.server.user.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT u FROM User u WHERE u.userUsername = ?1")
    Customer findCustomerByUsername(String userUsername);

}