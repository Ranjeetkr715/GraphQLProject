package com.ranjeetgithub.graphql.services.impl;

import com.ranjeetgithub.graphql.entities.Order;
import com.ranjeetgithub.graphql.repository.OrderRepository;
import com.ranjeetgithub.graphql.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int orderId ) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("User is not present in the database"));
    }

    @Override
    public Order updateOrderById(int orderId,Order order) {
        Order order1 = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("order is not present in the database"));
        order1.setAmount(order.getAmount());
        order1.setAddress(order.getAddress());
        order1.setOrderDetails(order.getOrderDetails());
        order1.setPrice(order.getPrice());
        orderRepository.save(order1);
        return order1;
    }

    @Override
    public boolean deleteOrderById(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("order is not present in the database"));
        orderRepository.delete(order);
        return true;
    }
}
