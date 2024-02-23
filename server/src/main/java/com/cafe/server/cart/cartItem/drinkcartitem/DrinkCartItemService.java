package com.cafe.server.cart.cartitem.drinkcartitem;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.cafe.server.product.drink.Drink;
import com.cafe.server.product.drink.DrinkService;

@Service
public class DrinkCartItemService {

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private DrinkCartItemRepository drinkCartItemRepository;

    /**
     * Fetch the DrinkCartItem, and the associated ChosenDrinkOptions
     * Fetch the Drink product, and the associated DrinkOption
     * Calculate the total price of the DrinkCartItem given the extra add-ons
     * 
     * @param cartItemId
     * @return
     */
    public Double calculateDrinkCartItemPrice(@NonNull Long cartItemId) {
        try {
            DrinkCartItem drinkCartItem = drinkCartItemRepository.findById(cartItemId)
                    .orElseThrow(() -> new RuntimeException("DrinkCartItem not found"));

            ChosenDrinkOptions drinkOptions = drinkCartItem.getChosenDrinkOptions();

            String chosenDrinkSize = drinkOptions.getChosenDrinkSize();
            Map<String, Integer> chosenDrinkAddons = drinkOptions.getChosenDrinkAddons();

            Drink drink = drinkService.getDrinkByProductId(drinkCartItem.getProduct().getProductId());

            // Initialize totalDrinkPrice with the base price of the drink
            Double totalDrinkPrice = drink.getProductCost();

            // Get information on the drink size and its associated price, add to
            // totalDrinkPrice
            Double chosenDrinkSizePrice = drink.getDrinkSizeOptions().get(chosenDrinkSize);
            totalDrinkPrice += chosenDrinkSizePrice;

            // Get information on the addons, refers to drink addon price list
            Map<String, Double> drinkAddonsMap = drink.getDrinkAddonsOptions();

            for (String addon : drinkAddonsMap.keySet()) {
                Integer quantity = chosenDrinkAddons.get(addon);
                if (quantity != null && quantity >= 1) {
                    Double price = drinkAddonsMap.get(addon);

                    totalDrinkPrice += (quantity * price);
                }
            }

            return totalDrinkPrice;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 100.0;
    }
}
