package com.cafe.server;

import java.util.LinkedHashMap;
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

    @Bean
    ApplicationListener<ApplicationReadyEvent> testDrinkService() {
        return event -> {

            final Map<String, Double> drinkSizeOptions = new LinkedHashMap<>();
            drinkSizeOptions.put("Small", 0.0);
            drinkSizeOptions.put("Medium", 1.0);
            drinkSizeOptions.put("Large", 2.0);

            final List<Integer> drinkSweetnessOptions = List.of(0, 50, 70, 100); // Sweetness options: 0%, 50%, 70%,
                                                                                  // 100%
            final List<String> drinkTemperatureOptions = List.of("Cold", "Hot"); // Temperature options: Cold, Hot

            final Map<String, Double> drinkAddonsOptions = new LinkedHashMap<>();
            drinkAddonsOptions.put("Grass Jelly", 1.0);
            drinkAddonsOptions.put("Sago", 1.0);
            drinkAddonsOptions.put("Pearls", 1.0);
            drinkAddonsOptions.put("Crystal Pearls", 1.0);

            drinkService.createDrink("Milk Tea", "Delicious milk tea", "Drink", 5.0,
                    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images/drink_bubbletea_1.jpg",
                    drinkSizeOptions,
                    drinkSweetnessOptions, drinkTemperatureOptions, drinkAddonsOptions);

            drinkService.createDrink("Brown Sugar Milk Tea", "Delicious brown sugar milk tea", "Drink", 7.0,
                    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images/drink_bubbletea_1.jpg",
                    drinkSizeOptions,
                    drinkSweetnessOptions, drinkTemperatureOptions, drinkAddonsOptions);

            drinkService.createDrink("Matcha Milk Tea", "Delicious matcha milk tea", "Drink", 6.0,
                    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images/drink_bubbletea_1.jpg",
                    drinkSizeOptions,
                    drinkSweetnessOptions, drinkTemperatureOptions, drinkAddonsOptions);

            drinkService.createDrink("Taro Milk Tea", "Delicious taro milk tea", "Drink", 6.0,
                    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images/drink_bubbletea_1.jpg",
                    drinkSizeOptions,
                    drinkSweetnessOptions, drinkTemperatureOptions, drinkAddonsOptions);

            foodService.createFood("Glutinous Rice Cake Dessert", "Tasty glutinous rice cake dessert", "Food", 8.0,
                    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images/homepage_food.jpg");

            foodService.createFood("Rice Cake Dessert", "Tasty rice cake strawberries", "Food", 8.0,
                    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images/homepage_food.jpg");

            foodService.createFood("Strawberry Cake", "Tasty cake with fresh strawberries", "Food", 8.0,
                    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images/homepage_food.jpg");

            foodService.createFood("Matcha Cake", "Tasty matcha cake", "Food", 8.0,
                    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images/homepage_food.jpg");

            merchandiseService.createMerchandise("White Roses Bouquet",
                    "Beautiful white roses wrapped in a bouquet. A perfect gift for a loved one!", "Merchandise", 40.0,
                    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images/homepage_flower_2.jpg");

            merchandiseService.createMerchandise("Dried Flowers Bouquet",
                    "Beautiful dried flowers in a bouquet. A perfect gift for a loved one!", "Merchandise", 40.0,
                    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images/homepage_flower_1.jpg");

            merchandiseService.createMerchandise("Tulips Bouquet",
                    "Beautiful tulips in a bouquet. A perfect gift for a loved one!", "Merchandise", 40.0, null);
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

            String chosenDrinkSize = "Medium"; // Size options: 'S' = +$0, 'M' = +$1, 'L' = +$2

            Integer chosenDrinkSweetness = 70; // Sweetness options: 0%, 50%, 70%, 100%

            String chosenDrinkTemperature = "Cold"; // Temperature options: Cold, Hot

            Map<String, Integer> chosenDrinkAddons = Map.of(
                    "Grass Jelly", 1, // Grass Jelly addon costs $1.0
                    "Sago", 1, // Sago addon costs $1.0
                    "Pearls", 0, // Pearls addon costs $1.0
                    "Crystal Pearls", 1 // Crystal Pearls addon costs $1.0
            );

            DrinkRequest drinkRequest = new DrinkRequest(chosenDrinkSize, chosenDrinkSweetness, chosenDrinkTemperature,
                    chosenDrinkAddons);

            cartService.addDrinkToCart(3L, 1L, drinkRequest);
            cartService.addDrinkToCart(3L, 1L, drinkRequest);
            cartService.addDrinkToCart(1L, 1L, drinkRequest);
        };
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> testOrderService() {
        return event -> {
            orderService.convertCartToOrder(1L);
            System.out.println("Converted Cart to Order");
        };
    }

}