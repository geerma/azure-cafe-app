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

    public void setSizeOption(Beverage beverage, String sizeOption) {
        beverage.setChosenSizeOption(sizeOption);
    }

    public void setSweetnessOption(Beverage beverage, Integer sweetnessOption) {
        beverage.setChosenSweetnessOption(sweetnessOption);
    }

    public void setTemperatureOption(Beverage beverage, String sweetnessOption) {
        beverage.setChosenTemperatureOption(sweetnessOption);
    }

}
