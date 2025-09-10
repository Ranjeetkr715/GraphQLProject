package com.ranjeetgithub.graphql.controller;

import com.ranjeetgithub.graphql.entities.Order;
import com.ranjeetgithub.graphql.entities.User;
import com.ranjeetgithub.graphql.services.impl.OrderServiceImpl;
import com.ranjeetgithub.graphql.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private UserServiceImpl userService;

    @MutationMapping(name = "createOrder")
    public Order createOrder(@Argument String orderDetails,@Argument String address,@Argument int price, @Argument double amount, @Argument int userId){
        User user = userService.getUserById(userId);
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setAmount(amount);
        order.setPrice(price);
        order.setUser(user);
        return orderService.createOrder(order);
    }

    @QueryMapping(name = "getAllOrder")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

    @QueryMapping(name = "getOrderById")
    public Order getOrderById(@Argument int orderId){
        return orderService.getOrderById(orderId);
    }

    @MutationMapping(name = "deleteOrderById")
    public boolean deleteOrderById(@Argument int orderId){
        orderService.deleteOrderById(orderId);
        return true;
    }

    @MutationMapping(name = "updateOrder")
    public Order updateOrder(@Argument int orderId, @Argument String orderDetails,@Argument String address, @Argument double amount){
        Order order = orderService.getOrderById(orderId); // fetch existing user
        if (order == null) {
            throw new RuntimeException("User not found with id: " + orderId);
        }

        if (orderDetails != null) order.setOrderDetails(orderDetails);
        if (address != null) order.setAddress(address);
        if (Objects.nonNull(amount)) order.setAmount(amount);

        return orderService.createOrder(order);
    }
}
