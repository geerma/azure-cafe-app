package com.cafe.server.cart.cartItem;

import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BeverageOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beverageId;

    public String chosenDrinkSize = "S"; // Size 'S', 'M', 'L'

    public Integer chosenDrinkSweetness = 100; // Sweetness options: 0%, 50%, 70%, 100%

    public String chosenDrinkTemperature = "Hot"; // Temperature options: Cold, Hot

    public Map<String, Integer> chosenDrinkOptions = Map.of(
            "Pearls", 0, // Pearls addon costs $1.5
            "Grass Jelly", 0, // Grass Jelly addon costs $1.5
            "Sago", 1 // Sago addon costs $1.5
    );

    public BeverageOptions(Long cartItemId, String chosenDrinkSize, Integer chosenDrinkSweetness,
            String chosenDrinkTemperature,
            Map<String, Integer> chosenDrinkOptions) {
        this.beverageId = cartItemId;
        this.chosenDrinkSize = chosenDrinkSize;
        this.chosenDrinkSweetness = chosenDrinkSweetness;
        this.chosenDrinkTemperature = chosenDrinkTemperature;
        this.chosenDrinkOptions = chosenDrinkOptions;
    }

    public Long getBeverageId() {
        return beverageId;
    }

    public void setBeverageId(Long beverageId) {
        this.beverageId = beverageId;
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

    public Map<String, Integer> getChosenDrinkOptions() {
        return chosenDrinkOptions;
    }

    public void setChosenDrinkOptions(Map<String, Integer> chosenDrinkOptions) {
        this.chosenDrinkOptions = chosenDrinkOptions;
    }

}
