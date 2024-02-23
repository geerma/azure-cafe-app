package com.cafe.server.order;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cafe.server.order.orderitem.OrderItem;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long userId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItemList;

    private Double totalOrderCost;

    protected Order() {

    }

    public Order(Long userId, Set<OrderItem> orderItemList, Double totalOrderCost) {
        this.userId = userId;
        this.orderItemList = orderItemList;
        this.totalOrderCost = totalOrderCost;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(Set<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Double getTotalOrderCost() {
        return totalOrderCost;
    }

    public void setTotalOrderCost(Double totalOrderCost) {
        this.totalOrderCost = totalOrderCost;
    }

    public Double calculateOrderCost() {
        Double totalCostTemp = 0.0;
        for (OrderItem orderItem : orderItemList) {
            totalCostTemp += orderItem.getOrderItemPrice();
        }
        return totalCostTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        return orderId != null && orderId.equals(((Order) o).orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getOrderId());
    }

}
