package com.cafe.server.user.customer;

import org.springframework.stereotype.Service;

import com.cafe.server.cart.CartService;

@Service
public class CustomerService {

    private final CartService cartService;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository, CartService cartService) {
        this.cartService = cartService;
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(String userName, String userEmail, String userUsername, String userPassword) {
        Customer newCustomer = new Customer(userName, userEmail, userUsername, userPassword, "Customer", null, null);

        return customerRepository.save(newCustomer);
    }
}