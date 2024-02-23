package com.cafe.server.order;

import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.server.cart.Cart;
import com.cafe.server.cart.CartRepository;
import com.cafe.server.cart.CartService;
import com.cafe.server.cart.cartitem.CartItem;
import com.cafe.server.cart.cartitem.CartItemRepository;
import com.cafe.server.cart.cartitem.drinkcartitem.DrinkCartItem;
import com.cafe.server.order.orderitem.OrderItem;
import com.cafe.server.order.orderitem.drinkorderitem.DrinkOrderItem;

@Service
public class OrderService {

    private final CartService cartService;

    private final CartRepository cartRepository;

    private final CartItemRepository cartItemRepository;

    private final OrderRepository orderRepository;

    public OrderService(CartService cartService, CartRepository cartRepository, CartItemRepository cartItemRepository, OrderRepository orderRepository) {
        this.cartService = cartService;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.orderRepository = orderRepository;
    }

    /**
     * 
     * Given a userId, convert the associated cart to an order
     * 
     * @param userId
     * @return
     */
    @Transactional
    public Order convertCartToOrder(@NonNull Long userId) {
        // Retrieve user cart and userCartItems
        Cart userCart = cartService.getCartByUserId(userId);
        Set<CartItem> userCartItems = userCart.getCartItems();

        Order newOrder = new Order(userId, new HashSet<>(), 0.0);

        for (CartItem item : userCartItems) {
            OrderItem newOrderItem = createOrderItem(item, newOrder);
            newOrder.getOrderItemList().add(newOrderItem);
        }

        newOrder.setTotalOrderCost(newOrder.calculateOrderCost());

        // Reset Cart
        cartRepository.save(userCart.resetCart());

        cartItemRepository.deleteAll(userCartItems);

        return orderRepository.save(newOrder);
    }

    /**
     * Creates an OrderItem from a CartItem
     * OR a DrinkOrderItem from a DrinkCartItem
     * 
     * @param item  - CartItem, or any class that inherits from it
     * @param order
     * @return
     */
    private OrderItem createOrderItem(CartItem item, Order order) {
        if (item instanceof DrinkCartItem) {
            DrinkCartItem drinkCartItem = (DrinkCartItem) item;
            return new DrinkOrderItem(drinkCartItem.getProduct(), order,
                    drinkCartItem.getQuantity(), drinkCartItem.getCartItemPrice(),
                    drinkCartItem.getChosenDrinkOptions());
        } else {
            return new OrderItem(item.getProduct(), order, item.getQuantity(),
                    item.getCartItemPrice());
        }
    }

}
