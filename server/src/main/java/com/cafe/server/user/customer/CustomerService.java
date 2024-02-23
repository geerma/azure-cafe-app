package com.cafe.server.user.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(String userName, String userEmail, String userUsername, String userPassword) {
        Customer newCustomer = new Customer(userName, userEmail, userUsername, userPassword, "Customer", null, null);

        return customerRepository.save(newCustomer);
    }
}