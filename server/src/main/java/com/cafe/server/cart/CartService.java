package com.cafe.server.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.server.cart.cartitem.CartItem;
import com.cafe.server.cart.cartitem.CartItemRepository;
import com.cafe.server.cart.cartitem.beveragecartitem.BeverageCartItem;
import com.cafe.server.cart.cartitem.beveragecartitem.BeverageCartItemService;
import com.cafe.server.cart.cartitem.beveragecartitem.ChosenBeverageOptions;
import com.cafe.server.cart.cartitem.beveragecartitem.BeverageRequest;
import com.cafe.server.product.Product;
import com.cafe.server.product.ProductService;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class CartService {

    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private final CartItemRepository cartItemRepository;

    @Autowired
    private final ProductService productService;

    @Autowired
    private final BeverageCartItemService beverageCartItemService;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository,
            ProductService productService, BeverageCartItemService beverageCartItemService) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.beverageCartItemService = beverageCartItemService;
    }

    /**
     * Create a new cart for the given userId
     * 
     * @param userId
     * @return
     */
    public Cart createCart(Long userId) {
        Cart cart = new Cart(userId);
        return cartRepository.save(cart);
    }

    /**
     * Retrieve a cart based on userId
     * 
     * @param userId
     * @return
     */
    public Cart getCartByUserId(@NonNull Long userId) {
        // Retrieve the cart associated with the given user ID
        Optional<Cart> optionalCart = cartRepository.findById(userId);
        return optionalCart.orElse(null); // Returns the cart if present, otherwise null
    }

    /**
     * Create a new BeverageItem from a beverageRequest and add it to the cart
     * associated with the userId
     * 
     * @param userId
     * @param productId
     * @param beverageRequest
     */
    @Transactional
    public void addBeverageToCart(@NonNull Long userId, @NonNull Long productId,
            @NonNull BeverageRequest beverageRequest) {
        try {
            Cart cart = getCartByUserId(userId);

            Product product = productService.getProductByProductId(productId);

            // Check if product already exists in the cart
            CartItem existingItem = null;
            for (CartItem item : cart.getCartItems()) {
                if (item.getProduct().getProductId().equals(product.getProductId())) {
                    existingItem = item;
                    break;
                }
            }

            // If product already exists in the cart, increment. Otherwise, add the item.
            if (existingItem != null) {
                existingItem.setQuantity(existingItem.getQuantity() + 1);
            } else {
                String chosenDrinkSize = beverageRequest.getChosenDrinkSize();
                Integer chosenDrinkSweetness = beverageRequest.getChosenDrinkSweetness();
                String chosenDrinkTemperature = beverageRequest.getChosenDrinkTemperature();
                Map<String, Integer> chosenDrinkAddons = beverageRequest.getChosenDrinkAddons();

                ChosenBeverageOptions beverageOptions = new ChosenBeverageOptions(chosenDrinkSize, chosenDrinkSweetness,
                        chosenDrinkTemperature, chosenDrinkAddons);

                // Create a new BeverageCartItem and add it to the cart
                BeverageCartItem newCartItem = new BeverageCartItem(product, cart, 1, beverageOptions);

                cartItemRepository.save(newCartItem);

                Double newCartItemPrice = beverageCartItemService
                        .calculateBeverageCartItemPrice(newCartItem.getCartItemId());
                newCartItem.setCartItemPrice(newCartItemPrice);
                cart.getCartItems().add(newCartItem);
            }

            cartRepository.save(cart);

            // Calculates the total price of all items in the cart and sets the cart value
            cart.setTotalCartPrice(calculateCartCostByUserId(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a new generic cartItem and add it to the cart associated with the userId
     * 
     * @param userId
     * @param productId
     */
    @Transactional
    public void addItemToCart(@NonNull Long userId, @NonNull Long productId) {
        try {
            Cart cart = getCartByUserId(userId);

            Product product = productService.getProductByProductId(productId);

            // Check if product already exists in the cart
            CartItem existingItem = null;
            for (CartItem item : cart.getCartItems()) {
                if (item.getProduct().getProductId().equals(product.getProductId())) {
                    existingItem = item;
                    break;
                }
            }

            // If product already exists in the cart, increment. Otherwise, add the item.
            if (existingItem != null) {
                existingItem.setQuantity(existingItem.getQuantity() + 1);
            } else {
                CartItem newCartItem = new CartItem(product, cart, 1);
                cart.getCartItems().add(newCartItem);
            }

            // Calculates the total price of all items in the cart and sets the cart value
            cart.setTotalCartPrice(calculateCartCostByUserId(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeItemFromCart(Long userId, Long productId) {
        // // Check if the product is already in the cart
        // CartItem itemToRemove = null;
        // for (CartItem item : cartItems) {
        // if (item.getProduct().equals(product)) {
        // itemToRemove = item;
        // break;
        // }
        // }

        // if (itemToRemove != null) {
        // // If the CartItem exists, decrease the quantity
        // int newQuantity = itemToRemove.getQuantity() - 1;
        // if (newQuantity <= 0) {
        // // If the quantity becomes zero or less, remove the item from the cart
        // cartItems.remove(itemToRemove);
        // } else {
        // // Otherwise, update the quantity
        // itemToRemove.setQuantity(newQuantity);
        // }
        // }
    }

    public Double calculateCartCostByUserId(@NonNull Long userId) throws Exception {
        Double totalCostTemp = 0.0;

        Cart userCart = getCartByUserId(userId);

        Set<CartItem> userCartItems = userCart.getCartItems();

        for (CartItem cartItem : userCartItems) {
            Integer cartQuantity = cartItem.getQuantity();
            Double cartItemPrice = cartItem.getCartItemPrice();

            totalCostTemp += (cartQuantity * cartItemPrice);
        }
        return totalCostTemp;
    }

}