package com.cafe.server.cart.cartitem.beveragecartitem;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.cafe.server.product.beverage.Beverage;
import com.cafe.server.product.beverage.BeverageService;

@Service
public class BeverageCartItemService {

    @Autowired
    private BeverageService beverageService;

    @Autowired
    private BeverageCartItemRepository beverageCartItemRepository;

    /**
     * Fetch the BeverageCartItem, and the associated ChosenBeverageOptions
     * Fetch the Beverage product, and the associated BeverageOption
     * Calculate the total price of the BeverageCartItem given the extra add-ons
     * 
     * @param cartItemId
     * @return
     */
    public Double calculateBeverageCartItemPrice(@NonNull Long cartItemId) {
        System.out.println("\ncalculateBeverageCartItemPrice");
        BeverageCartItem beverageCartItem = beverageCartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("BeverageCartItem not found"));

        System.out.println("\nBeverageCartItem Found");
        ChosenBeverageOptions beverageOptions = beverageCartItem.getBeverageOptions();

        String chosenDrinkSize = beverageOptions.getChosenDrinkSize();
        Map<String, Integer> chosenDrinkAddons = beverageOptions.getChosenDrinkAddons();

        try {
            System.out.println("\nFetching Beverage");
            Beverage beverage = beverageService.getBeverageByProductId(beverageCartItem.getProduct().getProductId());
            System.out.println("\n\n BEVERAGE FOUND " + beverage.getProductName());
            return beverage.getProductCost();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 100.0;
    }
}
