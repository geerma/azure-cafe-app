package com.cafe.server.product.drink;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/drinks")
public class DrinkController {

    private final DrinkRepository drinkRepository;

    public DrinkController(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @GetMapping("/")
    public Iterable<Drink> getDrinks() {
        return drinkRepository.findAll();
    }

    @PostMapping("/createdrink")
    @ResponseStatus(HttpStatus.CREATED)
    public Drink createDrink(@NonNull @RequestBody Drink drink) {
        // Implement drink creation
        return drinkRepository.save(drink);
    }

}
