package com.cafe.server.cart;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cafe.server.product.Product;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private HashMap<Long, Integer> productMap;
    private Double totalCartPrice;

    protected Cart() {
    }

    public Cart(Long userId) {
        this.userId = userId;
        this.productMap = new HashMap<>();
        this.totalCartPrice = 0.0;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public HashMap<Long, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(HashMap<Long, Integer> productMap) {
        this.productMap = productMap;
    }

    public Double getTotalCartPrice() {
        return totalCartPrice;
    }

    public void setTotalCartPrice(Double totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }

    public void addProductToCart(Product product) {
        Long productId = product.getProductId();
        Integer currentQuantity = this.productMap.get(productId);

        if (currentQuantity == null) {
            this.productMap.put(productId, 1);
        } else {
            this.productMap.put(productId, currentQuantity + 1);
        }
    }

    public void removeProductFromCart(Product product) {
        Long productId = product.getProductId();
        Integer currentQuantity = this.productMap.get(productId);

        if (currentQuantity > 1) {
            this.productMap.put(productId, currentQuantity - 1);
        } else if (currentQuantity == 1) {
            this.productMap.remove(productId);
        } else {
            return;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cart)) {
            return false;
        }
        return userId != null && userId.equals(((Cart) o).userId);
    }

    @Override
    public int hashCode() {
        return 31;
    }

}
