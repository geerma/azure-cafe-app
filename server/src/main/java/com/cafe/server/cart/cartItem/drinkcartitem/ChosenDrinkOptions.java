package com.cafe.server.cart.cartitem.drinkcartitem;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "chosen_drink_options")
public class ChosenDrinkOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drinkOptionId;

    public String chosenDrinkSize = "S"; // Size 'S', 'M', 'L'

    public Integer chosenDrinkSweetness = 100; // Sweetness options: 0%, 50%, 70%, 100%

    public String chosenDrinkTemperature = "Hot"; // Temperature options: Cold, Hot

    @ElementCollection
    @CollectionTable(name = "chosen_drink_addons", joinColumns = @JoinColumn(name = "cart_item_id"))
    @MapKeyColumn(name = "addon")
    @Column(name = "addon_quantity")
    public Map<String, Integer> chosenDrinkAddons = Map.of(
            "Pearls", 0, // Pearls addon costs $1.5
            "Grass Jelly", 0, // Grass Jelly addon costs $1.5
            "Sago", 1 // Sago addon costs $1.5
    );

    protected ChosenDrinkOptions() {

    }

    public ChosenDrinkOptions(String chosenDrinkSize, Integer chosenDrinkSweetness,
            String chosenDrinkTemperature,
            Map<String, Integer> chosenDrinkAddons) {
        this.chosenDrinkSize = chosenDrinkSize;
        this.chosenDrinkSweetness = chosenDrinkSweetness;
        this.chosenDrinkTemperature = chosenDrinkTemperature;
        this.chosenDrinkAddons = chosenDrinkAddons;
    }

    public Long getDrinkOptionId() {
        return drinkOptionId;
    }

    public void setDrinkOptionId(Long drinkOptionId) {
        this.drinkOptionId = drinkOptionId;
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
