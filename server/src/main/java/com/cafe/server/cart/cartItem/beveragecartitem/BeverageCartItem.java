package com.cafe.server.cart.cartitem.beveragecartitem;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cafe.server.cart.Cart;
import com.cafe.server.cart.cartitem.CartItem;
import com.cafe.server.product.Product;

@Entity
public class BeverageCartItem extends CartItem {

    // https://www.baeldung.com/jpa-cascade-types
    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "beverage_option_id")
    private ChosenBeverageOptions beverageOptions;
    
    private Double beverageCartItemPrice;

    protected BeverageCartItem() {

    }

    public BeverageCartItem(Product product, Cart cart, Integer quantity, ChosenBeverageOptions beverageOptions) {
        super(product, cart, quantity);
        this.beverageOptions = beverageOptions;
        this.beverageCartItemPrice = 0.1;
    }

    public ChosenBeverageOptions getBeverageOptions() {
        return beverageOptions;
    }

    public void setBeverageOptions(ChosenBeverageOptions beverageOptions) {
        this.beverageOptions = beverageOptions;
    }

    public Double getBeverageCartItemPrice() {
        return beverageCartItemPrice;
    }

    public void setBeverageCartItemPrice(Double beverageCartItemPrice) {
        this.beverageCartItemPrice = beverageCartItemPrice;
    }

}
