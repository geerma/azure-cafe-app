package com.cafe.server.cart;

import org.springframework.stereotype.Service;

import com.cafe.server.product.Product;
import com.cafe.server.product.ProductService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;

    public CartService(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    public Cart createCart(Long userId) {
        // Create a new cart for the given user
        Cart cart = new Cart(userId);
        return cartRepository.save(cart);
    }

    public Cart getCartByUserId(Long userId) {
        // Retrieve the cart associated with the given user ID
        Optional<Cart> optionalCart = cartRepository.findById(userId);
        return optionalCart.orElse(null); // Returns the cart if present, otherwise null
    }

    public void addItemToCart(Long userId, Long productId) {
        // Retrieve the cart for the user
        Cart cart = getCartByUserId(userId);

        // Retrieve the product price
        Product product;
        try {
            product = productService.getProductByProductId(productId);

            // Add the product to the cart
            cart.addProductToCart(product);

            // Update the cart in the database
            cartRepository.save(cart);
        } catch (Exception e) {
            return;
        }
    }

    public Double calculateCartCostByUserId(Long userId) throws Exception {
        Double totalCostTemp = 0.0; 

        Cart userCart = getCartByUserId(userId);

        HashMap<Long, Integer> productMap = userCart.getProductMap();

        for (Map.Entry<Long, Integer> entry : productMap.entrySet()) {
            Long productId = entry.getKey();
            Integer cartQuantity = entry.getValue();

            if (productId != null) {
                Double productPrice = productService.getPriceByProductId(productId);
                totalCostTemp += (productPrice * cartQuantity);
            }
        }
        return totalCostTemp;
    }

}