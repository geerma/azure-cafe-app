package com.cafe.server.order;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/")
    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/orderid/{orderid}")
    public Optional<Order> getOrderById(@PathVariable("orderid") Long orderId) {
        return orderRepository.findById(orderId);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@NonNull @RequestBody Order order) {
        return orderRepository.save(order);
    }

}
