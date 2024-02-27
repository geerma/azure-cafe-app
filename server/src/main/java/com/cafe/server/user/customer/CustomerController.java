package com.cafe.server.user.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import com.cafe.server.dto.UserRegistrationRequest;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@NonNull @RequestBody UserRegistrationRequest userRegistrationRequest) {
        Customer newCustomer = customerService.registerCustomer(userRegistrationRequest);

        return newCustomer;
    }

    @GetMapping("/")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
