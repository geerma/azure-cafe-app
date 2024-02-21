package com.cafe.server.product.beverage;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BeverageService {
    
    private final BeverageRepository beverageRepository;

    public BeverageService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    public Beverage createBeverage(String productName, String productDescription, String productCategory, Double productCost, Map<String, Double> drinkSizeOptions, List<Integer> drinkSweetnessOptions, List<String> drinkTemperatureOptions, Map<String, Double> drinkAddonsOptions) {  
        Beverage newBeverage = new Beverage(productName, productDescription, "Beverage", productCost, drinkSizeOptions, drinkSweetnessOptions, drinkTemperatureOptions, drinkAddonsOptions);
        return beverageRepository.save(newBeverage);
    }

}
