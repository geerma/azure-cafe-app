package com.cafe.server.product.food;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Food createFood(@NonNull @RequestBody Food food) {
        return foodRepository.save(food);
    }

    @GetMapping("/")
    public Iterable<Food> getFoods() {
        return foodRepository.findAll();
    }
}