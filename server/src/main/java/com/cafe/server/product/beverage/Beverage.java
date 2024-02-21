package com.cafe.server.product.beverage;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

import com.cafe.server.product.Product;

@Entity
public class Beverage extends Product {

    @ElementCollection
    @CollectionTable(name = "beverage_size_options", joinColumns = @JoinColumn(name = "beverage_id"))
    @MapKeyColumn(name = "size")
    @Column(name = "size_price")
    private Map<String, Double> drinkSizeOptions;

    @ElementCollection
    @CollectionTable(name = "beverage_sweetness_options", joinColumns = @JoinColumn(name = "beverage_id"))
    @Column(name = "sweetness")
    private List<Integer> drinkSweetnessOptions;

    @ElementCollection
    @CollectionTable(name = "beverage_temperature_options", joinColumns = @JoinColumn(name = "beverage_id"))
    @Column(name = "temperature")
    private List<String> drinkTemperatureOptions;

    @ElementCollection
    @CollectionTable(name = "beverage_addons_options", joinColumns = @JoinColumn(name = "beverage_id"))
    @MapKeyColumn(name = "addon")
    @Column(name = "addon_price")
    private Map<String, Double> drinkAddonsOptions;

    protected Beverage() {

    }

    public Beverage(String productName, String productDescription, String productCategory, Double productCost,
            Map<String, Double> drinkSizeOptions, List<Integer> drinkSweetnessOptions,
            List<String> drinkTemperatureOptions, Map<String, Double> drinkAddonsOptions) {
        super(productName, productDescription, productCategory, productCost);
        this.drinkSizeOptions = drinkSizeOptions;
        this.drinkSweetnessOptions = drinkSweetnessOptions;
        this.drinkTemperatureOptions = drinkTemperatureOptions;
        this.drinkAddonsOptions = drinkAddonsOptions;
    }

    public Map<String, Double> getDrinkSizeOptions() {
        return drinkSizeOptions;
    }

    public void setDrinkSizeOptions(Map<String, Double> drinkSizeOptions) {
        this.drinkSizeOptions = drinkSizeOptions;
    }

    public List<Integer> getDrinkSweetnessOptions() {
        return drinkSweetnessOptions;
    }

    public void setDrinkSweetnessOptions(List<Integer> drinkSweetnessOptions) {
        this.drinkSweetnessOptions = drinkSweetnessOptions;
    }

    public List<String> getDrinkTemperatureOptions() {
        return drinkTemperatureOptions;
    }

    public void setDrinkTemperatureOptions(List<String> drinkTemperatureOptions) {
        this.drinkTemperatureOptions = drinkTemperatureOptions;
    }

    public Map<String, Double> getDrinkAddonsOptions() {
        return drinkAddonsOptions;
    }

    public void setDrinkAddonsOptions(Map<String, Double> drinkAddonsOptions) {
        this.drinkAddonsOptions = drinkAddonsOptions;
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
        return this.getProductId() != null && this.getProductId().equals(otherBeverage.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getProductId());
    }

}
