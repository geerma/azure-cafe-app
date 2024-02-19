package com.cafe.server.product.beverage;

import javax.persistence.Entity;

import com.cafe.server.product.Product;

@Entity
public class Beverage extends Product {

    private Integer drinkSize; // mL

    protected Beverage() {

    }

    public Beverage(String productName, String productDescription, String productCategory, Double productCost,
            Integer productStock, Integer drinkSize) {
        super(productName, productDescription, productCategory, productCost, productStock);
        this.drinkSize = drinkSize;
    }

    public Integer getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(Integer drinkSize) {
        this.drinkSize = drinkSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Beverage)) {
            return false;
        }
        Beverage otherBeverage = (Beverage) o;
        return getProductId() != null && getProductId().equals(otherBeverage.getProductId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

}
