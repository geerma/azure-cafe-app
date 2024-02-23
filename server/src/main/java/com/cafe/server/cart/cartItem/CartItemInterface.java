package com.cafe.server.cart.cartitem;

import com.cafe.server.cart.Cart;
import com.cafe.server.product.Product;

public interface CartItemInterface {
    
    Product getProduct();
    Cart getCart();
    Integer getQuantity();
    Double getCartItemPrice();
    
}
