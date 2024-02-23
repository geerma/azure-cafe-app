package com.cafe.server.order.orderitem.drinkorderitem;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cafe.server.cart.cartitem.drinkcartitem.ChosenDrinkOptions;
import com.cafe.server.order.Order;
import com.cafe.server.order.orderitem.OrderItem;
import com.cafe.server.product.Product;

@Entity
public class DrinkOrderItem extends OrderItem {

    // https://www.baeldung.com/jpa-cascade-types
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "drink_option_id")
    private ChosenDrinkOptions drinkOptions;
    
    public DrinkOrderItem(Product product, Order order, Integer quantity, Double orderItemPrice, ChosenDrinkOptions drinkOptions) {
        super(product, order, quantity, orderItemPrice);
        this.drinkOptions = drinkOptions;
    }

    public ChosenDrinkOptions getDrinkOptions() {
        return drinkOptions;
    }

    public void setDrinkOptions(ChosenDrinkOptions drinkOptions) {
        this.drinkOptions = drinkOptions;
    }

    

}
