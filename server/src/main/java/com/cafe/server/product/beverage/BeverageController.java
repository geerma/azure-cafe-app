package com.cafe.server.product.beverage;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beverages")
public class BeverageController {

    private final BeverageRepository beverageRepository;

    public BeverageController(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Beverage createBeverage(@NonNull @RequestBody Beverage beverage) {
        return beverageRepository.save(beverage);
    }

    @GetMapping("/")
    public Iterable<Beverage> getBeverages() {
        return beverageRepository.findAll();
    }
}
