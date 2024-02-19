package com.cafe.server.cart;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart createCart(@NonNull @RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    @GetMapping("/")
    public Cart getCart(@NonNull Long userId) {
        return cartRepository.findById(userId).get();
    }
}
