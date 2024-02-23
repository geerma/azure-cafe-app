package com.cafe.server.order;

import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.server.cart.Cart;
import com.cafe.server.cart.CartService;
import com.cafe.server.cart.cartitem.CartItem;
import com.cafe.server.cart.cartitem.drinkcartitem.DrinkCartItem;
import com.cafe.server.order.orderitem.OrderItem;
import com.cafe.server.order.orderitem.drinkorderitem.DrinkOrderItem;

@Service
public class OrderService {

    private final CartService cartService;

    private final OrderRepository orderRepository;

    public OrderService(CartService cartService, OrderRepository orderRepository) {
        this.cartService = cartService;
        this.orderRepository = orderRepository;
    }

    /**
     * Given a userId, convert the associated cart to an order
     */
    @Transactional
    public Order convertCartToOrder(@NonNull Long userId) {
        System.out.println("\n\nconvertCartToOrder");

        // Retrieve user cart and userCartItems
        Cart userCart = cartService.getCartByUserId(userId);
        Set<CartItem> userCartItems = userCart.getCartItems();
    
        Order newOrder = new Order(userId, new HashSet<>(), 0.0);
    
        for (CartItem item : userCartItems) {
            OrderItem newOrderItem = createOrderItem(item, newOrder);
            newOrder.getOrderItemList().add(newOrderItem);
        }
    
        newOrder.setTotalOrderCost(99.99);
        return orderRepository.save(newOrder);
    }

    /**
     * Creates an OrderItem from a CartItem.
     * Checks for DrinkCartItem to create a DrinkOrderItem.
     * @param item
     * @param order
     * @return
     */
    private OrderItem createOrderItem(CartItem item, Order order) {
        System.out.println("\n\ncreateOrderItem");
        if (item instanceof DrinkCartItem) {
            DrinkCartItem drinkCartItem = (DrinkCartItem) item;
            return new DrinkOrderItem(drinkCartItem.getProduct(), order, 
                                      drinkCartItem.getQuantity(), drinkCartItem.getCartItemPrice(), 
                                      drinkCartItem.getDrinkOptions());
        } else {
            return new OrderItem(item.getProduct(), order, item.getQuantity(), 
                                 item.getCartItemPrice());
        }
    }

}
