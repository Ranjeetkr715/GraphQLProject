package com.ranjeetgithub.graphql.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int userId;
    private String name;
    private String email;
    private String phoneNo;
    private String password;
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(int userId, String name, String email, String phoneNo, String password, List<Order> orders) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.orders = orders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
