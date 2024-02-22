package com.cafe.server.cart.cartitem;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartitems")
public class CartItemController {

    private final CartItemRepository cartItemRepository;

    public CartItemController(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CartItem createCartItem(@NonNull @RequestBody CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @GetMapping("/")
    public CartItem getCartItem(@NonNull Long id) {
        return cartItemRepository.findById(id).get();
    }
}
