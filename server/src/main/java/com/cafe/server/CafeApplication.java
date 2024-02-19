package com.cafe.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import com.cafe.server.product.beverage.Beverage;
import com.cafe.server.product.beverage.BeverageRepository;

import com.cafe.server.user.customer.Customer;
import com.cafe.server.user.customer.CustomerRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class CafeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafeApplication.class, args);
    }

    @SuppressWarnings("null")
    @Bean
    ApplicationListener<ApplicationReadyEvent> beverageListener(BeverageRepository repository) {
        return event->repository
            .saveAll(Stream.of("Drink A", "Drink B", "Drink C").map(name->new Beverage(name, "Description", "Drink", 5.0, 10, 500)).collect(Collectors.toList()))
            .forEach(System.out::println);
    }

    @SuppressWarnings("null")
    @Bean
    ApplicationListener<ApplicationReadyEvent> userListener(CustomerRepository repository) {
        return event->repository
            .saveAll(Stream.of("Customer A", "Customer B", "Customer C").map(name->new Customer(name, "email@testemail.com", "Username", "Password", "Customer", "Address", "Payment")).collect(Collectors.toList()))
            .forEach(System.out::println);
    }

}