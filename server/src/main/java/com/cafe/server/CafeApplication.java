package com.cafe.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import com.cafe.server.product.beverage.Beverage;
import com.cafe.server.product.beverage.BeverageRepository;

import com.cafe.server.user.customer.CustomerService;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class CafeApplication {

    @Autowired
    private CustomerService customerService;

    // @Autowired
    // private ProductService productService;

    // @Autowired
    // private CartService cartService;

    public static void main(String[] args) {
        SpringApplication.run(CafeApplication.class, args);
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> testCustomerService() {
        return event -> {
            customerService.createCustomer("New Customer 1", "newcustomer1@test.com", "newcustomer1",
                    "newpassword1");
            customerService.createCustomer("New Customer 2", "newcustomer2@test.com", "newcustomer2",
            "newpassword2");
            customerService.createCustomer("New Customer 3", "newcustomer3@test.com", "newcustomer3",
            "newpassword3");
        };
    }

}