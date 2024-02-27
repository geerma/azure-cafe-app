package com.cafe.server.user.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import com.cafe.server.dto.UserRegistrationRequest;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/username/{username}")
    public Optional<Customer> getCustomerByUsername(@PathVariable("username") String username) {
        return customerRepository.findByUsername(username);
    }

    @GetMapping("/userid/{userid}")
    public Optional<Customer> getCustomerById(@PathVariable("userid") Long userId) {
        return customerRepository.findById(userId);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@NonNull @RequestBody UserRegistrationRequest userRegistrationRequest) {
        Customer newCustomer = customerService.registerCustomer(userRegistrationRequest);

        return newCustomer;
    }

}
