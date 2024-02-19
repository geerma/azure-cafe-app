package com.cafe.server.order;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@NonNull @RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/")
    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }
}
