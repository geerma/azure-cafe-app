package com.cafe.server.product.drink;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Drink getDrinkByProductId(@NonNull Long productId) throws Exception {
        Optional<Drink> productOptional = drinkRepository.findById(productId);

        // Check if Drink is present in the optional
        if (productOptional.isPresent()) {
            Drink product = productOptional.get();
            return product;
        } else {
            throw new Exception("Drink with ID " + productId + " not found");
        }
    }

    public Drink createDrink(String productName, String productDescription, String productCategory,
            Double productCost, Map<String, Double> drinkSizeOptions, List<Integer> drinkSweetnessOptions,
            List<String> drinkTemperatureOptions, Map<String, Double> drinkAddonsOptions) {
        Drink newDrink = new Drink(productName, productDescription, "Drink", productCost, drinkSizeOptions,
                drinkSweetnessOptions, drinkTemperatureOptions, drinkAddonsOptions);
        return drinkRepository.save(newDrink);
    }

}
