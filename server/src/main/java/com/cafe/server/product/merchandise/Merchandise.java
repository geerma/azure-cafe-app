package com.cafe.server.product.merchandise;

import javax.persistence.Entity;

import com.cafe.server.product.Product;

@Entity
public class Merchandise extends Product {

    protected Merchandise() {

    }

    public Merchandise(String productName, String productDescription, String productCategory, Double productCost) {
        super(productName, productDescription, "Merchandise", productCost);
    }

}
