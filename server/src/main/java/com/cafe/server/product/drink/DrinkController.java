package com.cafe.server.product.drink;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    private final DrinkRepository drinkRepository;

    public DrinkController(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Drink createDrink(@NonNull @RequestBody Drink drink) {
        return drinkRepository.save(drink);
    }

    @GetMapping("/")
    public Iterable<Drink> getDrinks() {
        return drinkRepository.findAll();
    }
}
