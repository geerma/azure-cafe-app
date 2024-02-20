package com.cafe.server.product.beverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import com.cafe.server.product.Product;

@Entity
public class Beverage extends Product {

    private Map<String, Double> drinkSizeOptions; // S, M, L
    private List<Integer> drinkSweetnessOptions; // 0, 50, 70, 100
    private List<String> drinkTemperatureOptions; // Cold (No/Less/Regular/More Ice), Hot
    private Map<String, Double> drinkAddonsOptions; // Pearls, Grass Jelly, Sago

    private String chosenSizeOption;
    private Integer chosenSweetnessOption;
    private String chosenTemperatureOption;
    private Map<String, Integer> chosenAddons;

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

    public String getChosenSizeOption() {
        return chosenSizeOption;
    }

    public void setChosenSizeOption(String chosenSizeOption) {
        this.chosenSizeOption = chosenSizeOption;
    }

    public Integer getChosenSweetnessOption() {
        return chosenSweetnessOption;
    }

    public void setChosenSweetnessOption(Integer chosenSweetnessOption) {
        this.chosenSweetnessOption = chosenSweetnessOption;
    }

    public String getChosenTemperatureOption() {
        return chosenTemperatureOption;
    }

    public void setChosenTemperatureOption(String chosenTemperatureOption) {
        this.chosenTemperatureOption = chosenTemperatureOption;
    }

    public Map<String, Integer> getChosenAddons() {
        return chosenAddons;
    }

    public void setChosenAddons(Map<String, Integer> chosenAddons) {
        this.chosenAddons = chosenAddons;
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
