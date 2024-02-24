package com.cafe.server.dto;

import java.util.Map;

/**
 * Used for JSON requests
 */
public class DrinkRequest {
    private String chosenDrinkSize;
    private Integer chosenDrinkSweetness;
    private String chosenDrinkTemperature;
    private Map<String, Integer> chosenDrinkAddons;

    protected DrinkRequest() {

    }

    public DrinkRequest(String chosenDrinkSize, Integer chosenDrinkSweetness, String chosenDrinkTemperature,
            Map<String, Integer> chosenDrinkAddons) {
        this.chosenDrinkSize = chosenDrinkSize;
        this.chosenDrinkSweetness = chosenDrinkSweetness;
        this.chosenDrinkTemperature = chosenDrinkTemperature;
        this.chosenDrinkAddons = chosenDrinkAddons;
    }

    public String getChosenDrinkSize() {
        return chosenDrinkSize;
    }

    public void setChosenDrinkSize(String chosenDrinkSize) {
        this.chosenDrinkSize = chosenDrinkSize;
    }

    public Integer getChosenDrinkSweetness() {
        return chosenDrinkSweetness;
    }

    public void setChosenDrinkSweetness(Integer chosenDrinkSweetness) {
        this.chosenDrinkSweetness = chosenDrinkSweetness;
    }

    public String getChosenDrinkTemperature() {
        return chosenDrinkTemperature;
    }

    public void setChosenDrinkTemperature(String chosenDrinkTemperature) {
        this.chosenDrinkTemperature = chosenDrinkTemperature;
    }

    public Map<String, Integer> getChosenDrinkAddons() {
        return chosenDrinkAddons;
    }

    public void setChosenDrinkAddons(Map<String, Integer> chosenDrinkAddons) {
        this.chosenDrinkAddons = chosenDrinkAddons;
    }

}