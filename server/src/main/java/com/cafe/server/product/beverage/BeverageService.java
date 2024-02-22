package com.cafe.server.product.beverage;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class BeverageService {

    private final BeverageRepository beverageRepository;

    public BeverageService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    public Beverage getBeverageByProductId(@NonNull Long productId) throws Exception {
        Optional<Beverage> productOptional = beverageRepository.findById(productId);

        // Check if product is present in the optional
        if (productOptional.isPresent()) {
            Beverage product = productOptional.get();
            return product;
        } else {
            throw new Exception("Beverage with ID " + productId + " not found");
        }
    }

    public Beverage createBeverage(String productName, String productDescription, String productCategory,
            Double productCost, Map<String, Double> drinkSizeOptions, List<Integer> drinkSweetnessOptions,
            List<String> drinkTemperatureOptions, Map<String, Double> drinkAddonsOptions) {
        Beverage newBeverage = new Beverage(productName, productDescription, "Beverage", productCost, drinkSizeOptions,
                drinkSweetnessOptions, drinkTemperatureOptions, drinkAddonsOptions);
        return beverageRepository.save(newBeverage);
    }

}
