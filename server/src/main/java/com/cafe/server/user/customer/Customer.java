package com.cafe.server.user.customer;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cafe.server.cart.Cart;
import com.cafe.server.user.CafeUser;

@Entity
public class Customer extends CafeUser {

    private String billingAddress;
    private String paymentMethod;

    // https://www.baeldung.com/jpa-cascade-types
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private ArrayList<Integer> orderList;
    private ArrayList<Integer> reservationList;

    protected Customer() {

    }

    public Customer(String username, String password, String email) {
        super(username, password, email, "USER");
        this.billingAddress = null;
        this.paymentMethod = null;
        this.cart = new Cart(this.getUserId());
        this.orderList = new ArrayList<>();
        this.reservationList = new ArrayList<>();
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<Integer> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Integer> orderList) {
        this.orderList = orderList;
    }

    public ArrayList<Integer> getReservationList() {
        return reservationList;
    }

    public void setReservationList(ArrayList<Integer> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer otherCustomer = (Customer) o;
        return getUserId() != null && getUserId().equals(otherCustomer.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId());
    }

}