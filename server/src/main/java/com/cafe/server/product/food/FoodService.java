package com.cafe.server.product.food;

import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food getFoodByProductId(@NonNull Long productId) throws Exception {
        Optional<Food> productOptional = foodRepository.findById(productId);

        // Check if Food is present in the optional
        if (productOptional.isPresent()) {
            Food product = productOptional.get();
            return product;
        } else {
            throw new Exception("Food with ID " + productId + " not found");
        }
    }

    public Food createFood(String productName, String productDescription, String productCategory,
            Double productCost) {
        Food newFood = new Food(productName, productDescription, "Food", productCost);
        return foodRepository.save(newFood);
    }

}
