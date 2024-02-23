package com.cafe.server.product.food;

import javax.persistence.Entity;

import com.cafe.server.product.Product;

@Entity
public class Food extends Product {

    protected Food() {

    }

    public Food(String productName, String productDescription, String productCategory, Double productCost) {
        super(productName, productDescription, "Food", productCost);
    }

}
