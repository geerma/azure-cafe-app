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
import com.cafe.server.dto.DrinkRequest;
import com.cafe.server.dto.UserRegistrationRequest;
import com.cafe.server.order.OrderService;
import com.cafe.server.product.drink.DrinkService;
import com.cafe.server.product.food.FoodService;
import com.cafe.server.product.merchandise.MerchandiseService;
import com.cafe.server.user.customer.CustomerService;

@SpringBootApplication
public class CafeApplication {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private MerchandiseService merchandiseService;

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
            drinkService.createDrink("Matcha Milk Tea", "Delicious matcha milk tea", "Drink", 5.0, drinkSizeOptions,
                    drinkSweetnessOptions, drinkTemperatureOptions, drinkAddonsOptions);
                    
            foodService.createFood("Strawberry Cake", "Tasty cake with fresh strawberries", "Food", 8.0);

            merchandiseService.createMerchandise("Pink Tulip Bouquet",
                    "Beautiful pink tulips wrapped in a bouquet. A perfect gift for a loved one!", "Merchandise", 40.0);
        };
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> testCustomerService() {
        return event -> {

            UserRegistrationRequest userRegistrationRequest1 = new UserRegistrationRequest("newcustomer1",
            "newpassword1", "newcustomer1@test.com");

            UserRegistrationRequest userRegistrationRequest2 = new UserRegistrationRequest("newcustomer2",
            "newpassword2", "newcustomer2@test.com");

            UserRegistrationRequest userRegistrationRequest3 = new UserRegistrationRequest("newcustomer3",
            "newpassword3", "newcustomer3@test.com");

            customerService.registerCustomer(userRegistrationRequest1);
            customerService.registerCustomer(userRegistrationRequest2);
            customerService.registerCustomer(userRegistrationRequest3);
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