package com.cafe.server.cart.cartitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cartitems")
public class CartItemController {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemController(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @GetMapping("/")
    public Iterable<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    @GetMapping("/cartitemid/{cartitemid}")
    public CartItem getCartItem(@NonNull Long cartItemId) {
        return cartItemRepository.findById(cartItemId).get();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CartItem createCartItem(@NonNull @RequestBody CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

}
