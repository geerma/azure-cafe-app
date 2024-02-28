package com.cafe.server.product.food;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {

    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping("/")
    public Iterable<Food> getFoods() {
        return foodRepository.findAll();
    }

    @PostMapping("/createfood")
    @ResponseStatus(HttpStatus.CREATED)
    public Food createFood(@NonNull @RequestBody Food food) {
        // Implement food creation
        return foodRepository.save(food);
    }

}