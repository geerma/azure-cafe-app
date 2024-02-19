package com.cafe.server.user.customer;

import java.util.ArrayList;

import javax.persistence.Entity;

import com.cafe.server.user.User;

@Entity
public class Customer extends User {

    private String billingAddress;
    private String paymentMethod;
    private ArrayList<Integer> orderList;
    private ArrayList<Integer> reservationList;

    protected Customer() {
    }

    public Customer(String userName, String userEmail, String userUsername, String userPassword, String userRole, String billingAddress,
            String paymentMethod) {
        super(userName, userEmail, userUsername, userPassword, userRole);
        this.billingAddress = billingAddress;
        this.paymentMethod = paymentMethod;
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
        return 31;
    }
}