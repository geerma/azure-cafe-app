package com.cafe.server;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import com.cafe.server.cart.CartService;
import com.cafe.server.cart.cartitem.drinkcartitem.DrinkRequest;
import com.cafe.server.order.OrderService;
import com.cafe.server.product.drink.DrinkService;
import com.cafe.server.user.customer.CustomerService;

@SpringBootApplication
public class CafeApplication {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(CafeApplication.class, args);
    }

    public Map<String, Double> drinkSizeOptions = Map.of(
            "S", 0.0, // Size 'S' is the base cost
            "M", 1.0, // Size 'M' costs additional $1.0
            "L", 2.0 // Size 'L' costs additional $2.0
    );

    public List<Integer> drinkSweetnessOptions = List.of(0, 50, 70, 100); // Sweetness options: 0%, 50%, 70%, 100%

    public List<String> drinkTemperatureOptions = List.of("Cold", "Hot"); // Temperature options: Cold, Hot

    public Map<String, Double> drinkAddonsOptions = Map.of(
            "Pearls", 1.5, // Pearls addon costs $1.5
            "Grass Jelly", 2.0, // Grass Jelly addon costs $2.0
            "Sago", 1.0 // Sago addon costs $1.0
    );

    @Bean
    ApplicationListener<ApplicationReadyEvent> testDrinkService() {
        return event -> {
            drinkService.createDrink("Drink A", "Drink Description", "Drink", 5.0, drinkSizeOptions,
                    drinkSweetnessOptions, drinkTemperatureOptions, drinkAddonsOptions);
        };
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> testCustomerService() {
        return event -> {
            customerService.createCustomer("New Customer 1", "newcustomer1@test.com", "newcustomer1",
                    "newpassword1");
            customerService.createCustomer("New Customer 2", "newcustomer2@test.com", "newcustomer2",
                    "newpassword2");
            customerService.createCustomer("New Customer 3", "newcustomer3@test.com", "newcustomer3",
                    "newpassword3");
        };
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> testCartService() {
        return event -> {

            String chosenDrinkSize = "M"; // Size options: 'S' = +$0, 'M' = +$1, 'L' = +$2

            Integer chosenDrinkSweetness = 100; // Sweetness options: 0%, 50%, 70%, 100%

            String chosenDrinkTemperature = "Hot"; // Temperature options: Cold, Hot

            Map<String, Integer> chosenDrinkAddons = Map.of(
                    "Pearls", 0, // Pearls addon costs $1.5
                    "Grass Jelly", 2, // Grass Jelly addon costs $2.0
                    "Sago", 1 // Sago addon costs $1.0
            );

            DrinkRequest drinkRequest = new DrinkRequest(chosenDrinkSize, chosenDrinkSweetness, chosenDrinkTemperature,
                    chosenDrinkAddons);

            cartService.addDrinkToCart(3L, 1L, drinkRequest);
            cartService.addDrinkToCart(3L, 1L, drinkRequest);
            cartService.addDrinkToCart(1L, 1L, drinkRequest);

            cartService.decreaseQuantityFromCart(1L, 1L);
        };
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> testOrderService() {
        return event -> {
            orderService.convertCartToOrder(3L);
            System.out.println("Converted Cart to Order");
        };
    }

}