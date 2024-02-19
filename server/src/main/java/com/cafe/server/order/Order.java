package com.cafe.server.order;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cafe.server.product.Product;

@Entity
@Table(name = "orders")
public abstract class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    private Long userId;
    private ArrayList<Product> productList;
    private Double totalOrderCost;

    protected Order() {

    }

    public Order(Long userId, ArrayList<Product> productList, Double totalOrderCost) {
        this.userId = userId;
        this.productList = productList;
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

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Double getTotalOrderCost() {
        return totalOrderCost;
    }

    public void setTotalOrderCost(Double totalOrderCost) {
        this.totalOrderCost = totalOrderCost;
    }

    public Double calculateOrderCost() {
        Double totalCostTemp = 0.0;
        for (Product product : productList) {
            totalCostTemp += product.getProductCost();
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
        return 31;
    }

}
