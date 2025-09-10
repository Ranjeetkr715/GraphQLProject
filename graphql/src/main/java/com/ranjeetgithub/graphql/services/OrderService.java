package com.ranjeetgithub.graphql.services;

import com.ranjeetgithub.graphql.entities.Order;
import com.ranjeetgithub.graphql.entities.User;

import java.util.List;

public interface OrderService {

    public Order createOrder(Order order);

    public List<Order> getAllOrder();

    public Order getOrderById(int orderId);

    public Order updateOrderById(int orderId,Order order);

    public boolean deleteOrderById(int orderId);
}
