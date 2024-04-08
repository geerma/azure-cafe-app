package com.cafe.server.product.merchandise;

import javax.persistence.Entity;

import com.cafe.server.product.Product;

@Entity
public class Merchandise extends Product {

    protected Merchandise() {

    }

    public Merchandise(String productName, String productDescription, String productCategory, Double productCost, String productImageURL) {
        super(productName, productDescription, "Merchandise", productCost, productImageURL);
    }

}
