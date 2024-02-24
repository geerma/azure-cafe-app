package com.cafe.server.user.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cafe.server.dto.UserLoginRequest;
import com.cafe.server.dto.UserRegistrationRequest;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, BCryptPasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer registerCustomer(UserRegistrationRequest request) {
        String userName = request.getUserName();
        String userUsername = request.getUserUsername();
        String userEmail = request.getUserEmail();
        String rawPassword = request.getUserPassword();

        // Hash and salt the password before storing it
        String encodedPassword = passwordEncoder.encode(rawPassword);

        Customer newCustomer = new Customer(userName, userEmail, userUsername, encodedPassword, "Customer", null, null);

        return customerRepository.save(newCustomer);
    }

    public boolean loginCustomer(UserLoginRequest request) {

        String userUsername = request.getUserUsername();
        String rawPassword = request.getUserPassword();

        Customer customer = customerRepository.findCustomerByUsername(userUsername);

        if (customer != null) {
            String encodedPassword = customer.getUserPassword();
            if (passwordEncoder.matches(rawPassword, encodedPassword)) {
                // User is authenticated, return true
                return true;
            }
        }

        // User is not authenticated, return false
        return false;
    }

    // public Customer createCustomer(String userName, String userEmail, String
    // userUsername, String userPassword) {
    // Customer newCustomer = new Customer(userName, userEmail, userUsername,
    // userPassword, "Customer", null, null);

    // return customerRepository.save(newCustomer);
    // }
}