package com.cafe.server.user.customer;

import java.util.Optional;

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
        String username = request.getUsername();
        String rawPassword = request.getPassword();
        String email = request.getEmail();

        // Hash and salt the password before storing it
        String encodedPassword = passwordEncoder.encode(rawPassword);

        Customer newCustomer = new Customer(username, encodedPassword, email);

        return customerRepository.save(newCustomer);
    }

    public boolean loginCustomer(UserLoginRequest request) {

        String userUsername = request.getUsername();
        String rawPassword = request.getPassword();

        Optional<Customer> customer = customerRepository.findByUsername(userUsername);

        if (customer.isPresent()) {
            String encodedPassword = customer.get().getPassword();
            if (passwordEncoder.matches(rawPassword, encodedPassword)) {
                // User is authenticated, return true
                return true;
            }
        }

        // User is not authenticated, return false
        return false;
    }

}