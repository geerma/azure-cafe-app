package com.cafe.server.cart;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cafe.server.cart.cartItem.CartItem;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems = new HashSet<CartItem>();

    private Double totalCartPrice;

    protected Cart() {

    }

    public Cart(Long userId) {
        this.cartId = userId;
        this.totalCartPrice = 0.0;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cart) {
        this.cartItems = cart;
    }

    public Double getTotalCartPrice() {
        return totalCartPrice;
    }

    public void setTotalCartPrice(Double totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cart)) {
            return false;
        }
        return cartId != null && cartId.equals(((Cart) o).cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }

}
