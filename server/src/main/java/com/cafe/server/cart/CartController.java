package com.cafe.server.cart;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import com.cafe.server.cart.cartitem.drinkcartitem.DrinkRequest;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartRepository cartRepository;
    private final CartService cartService;

    public CartController(CartRepository cartRepository, CartService cartService) {
        this.cartRepository = cartRepository;
        this.cartService = cartService;
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

    @PostMapping("/addItem/{userId}/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItemToCart(@NonNull @PathVariable Long userId, @NonNull @PathVariable Long productId) {
        cartService.addItemToCart(userId, productId);
    }

    /**
     * 
     * Example Request Body:
     * {
     * "chosenDrinkSize": "S",
     * "chosenDrinkSweetness": 100,
     * "chosenDrinkTemperature": "Hot",
     * "chosenDrinkAddons": {
     * "Pearls": 0,
     * "Grass Jelly": 0,
     * "Sago": 1
     * }
     * }
     * 
     * @param userId
     * @param productId
     * @param drinkRequest
     */
    @PostMapping("/addDrink/{userId}/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDrinkToCart(@NonNull @PathVariable Long userId, @NonNull @PathVariable Long productId,
            @NonNull @RequestBody DrinkRequest drinkRequest) {
        cartService.addDrinkToCart(userId, productId, drinkRequest);
        ResponseEntity.ok("Drink with Product ID " + productId + " has been added to the cart.");
    }

}
