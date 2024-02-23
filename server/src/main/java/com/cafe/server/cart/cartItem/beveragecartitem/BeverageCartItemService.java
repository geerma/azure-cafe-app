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
        System.out.println("\n\n\ncalculateBeverageCartItemPrice");
        try {
            BeverageCartItem beverageCartItem = beverageCartItemRepository.findById(cartItemId)
                    .orElseThrow(() -> new RuntimeException("BeverageCartItem not found"));

            ChosenBeverageOptions beverageOptions = beverageCartItem.getBeverageOptions();

            String chosenDrinkSize = beverageOptions.getChosenDrinkSize();
            Map<String, Integer> chosenDrinkAddons = beverageOptions.getChosenDrinkAddons();

            System.out.println("\nFetching Beverage");
            Beverage beverage = beverageService.getBeverageByProductId(beverageCartItem.getProduct().getProductId());

            // Initialize totalBeveragePrice with the base price of the beverage
            Double totalBeveragePrice = beverage.getProductCost();

            // Get information on the of the size and its associated price, add to
            // totalBeveragePrice
            Double chosenDrinkSizePrice = beverage.getDrinkSizeOptions().get(chosenDrinkSize);
            totalBeveragePrice += chosenDrinkSizePrice;

            // Get information on the addons, refers to beverage addon price list
            Map<String, Double> drinkAddonsMap = beverage.getDrinkAddonsOptions();

            for (String addon : drinkAddonsMap.keySet()) {
                Integer quantity = chosenDrinkAddons.get(addon);
                if (quantity != null && quantity >= 1) {
                    Double price = drinkAddonsMap.get(addon);

                    totalBeveragePrice += (quantity * price);
                }
            }

            return totalBeveragePrice;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 100.0;
    }
}
