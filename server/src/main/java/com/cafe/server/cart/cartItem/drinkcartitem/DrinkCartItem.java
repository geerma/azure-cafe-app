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
    @JoinColumn(name = "chosen_drink_option_id")
    private ChosenDrinkOptions chosenDrinkOptions;

    protected DrinkCartItem() {

    }

    public DrinkCartItem(Product product, Cart cart, Integer quantity, ChosenDrinkOptions chosenDrinkOptions) {
        super(product, cart, quantity);
        this.chosenDrinkOptions = chosenDrinkOptions;
    }

    public ChosenDrinkOptions getChosenDrinkOptions() {
        return chosenDrinkOptions;
    }

    public void setChosenDrinkOptions(ChosenDrinkOptions chosenDrinkOptions) {
        this.chosenDrinkOptions = chosenDrinkOptions;
    }

}
