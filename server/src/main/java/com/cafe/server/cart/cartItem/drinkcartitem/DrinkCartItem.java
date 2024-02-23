package com.cafe.server.cart.cartitem.drinkcartitem;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cafe.server.cart.Cart;
import com.cafe.server.cart.cartitem.CartItem;
import com.cafe.server.product.Product;

@Entity
public class DrinkCartItem extends CartItem {

    // https://www.baeldung.com/jpa-cascade-types
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "drink_option_id")
    private ChosenDrinkOptions drinkOptions;

    protected DrinkCartItem() {

    }

    public DrinkCartItem(Product product, Cart cart, Integer quantity, ChosenDrinkOptions drinkOptions) {
        super(product, cart, quantity);
        this.drinkOptions = drinkOptions;
    }

    public ChosenDrinkOptions getDrinkOptions() {
        return drinkOptions;
    }

    public void setDrinkOptions(ChosenDrinkOptions drinkOptions) {
        this.drinkOptions = drinkOptions;
    }

}
