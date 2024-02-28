package com.cafe.server.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import com.cafe.server.dto.DrinkRequest;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    private final CartRepository cartRepository;
    private final CartService cartService;

    @Autowired
    public CartController(CartRepository cartRepository, CartService cartService) {
        this.cartRepository = cartRepository;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public Iterable<Cart> getCarts() {
        return cartRepository.findAll();
    }

    @GetMapping("/userid/{userid}")
    public Cart getCartById(@NonNull @PathVariable("userid") Long userId) {
        return cartRepository.findById(userId).get();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart createCart(@NonNull @RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    @PostMapping("/addItem/{userid}/{productid}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItemToCart(@NonNull @PathVariable("userid") Long userId, @NonNull @PathVariable("productid") Long productId) {
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
    @PostMapping("/addDrink/{userid}/{productid}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDrinkToCart(@NonNull @PathVariable("userid") Long userId, @NonNull @PathVariable("productid") Long productId,
            @NonNull @RequestBody DrinkRequest drinkRequest) {
        cartService.addDrinkToCart(userId, productId, drinkRequest);
        ResponseEntity.ok("Drink with Product ID " + productId + " has been added to the cart.");
    }

}
