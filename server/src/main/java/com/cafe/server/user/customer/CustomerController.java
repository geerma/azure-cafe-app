package com.cafe.server.user.customer;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@NonNull @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
