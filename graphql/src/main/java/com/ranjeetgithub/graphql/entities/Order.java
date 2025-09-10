package com.ranjeetgithub.graphql.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Order_details")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String orderDetails;
    private String address;
    private int price;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Order() {

    }

    public Order(int orderId, String orderDetails, String address, int price, LocalDate DATE, double amount) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
        this.address = address;
        this.price = price;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
