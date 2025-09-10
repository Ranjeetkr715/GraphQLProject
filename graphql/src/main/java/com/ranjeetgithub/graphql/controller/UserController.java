package com.ranjeetgithub.graphql.controller;

import com.ranjeetgithub.graphql.entities.User;
import com.ranjeetgithub.graphql.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @MutationMapping(name = "createUser")
    public User createUser(@Argument String name,@Argument String email,@Argument String phone,@Argument String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNo(phone);
        user.setPassword(password);
        return userService.createUser(user);
    }

    @QueryMapping(name = "getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @QueryMapping(name = "getUserById")
    public User getUser(@Argument int userId){
        return userService.getUserById(userId);
    }

    @MutationMapping(name = "deleteUserById")
    public boolean deleteUserById(@Argument int userId){
        return userService.deleteUserById(userId);
    }

    @MutationMapping(name = "updateUser")
    public User updateUser(@Argument int userId,
                           @Argument String name,
                           @Argument String email,
                           @Argument String phoneNo,
                           @Argument String password) {
        User user = userService.getUserById(userId); // fetch existing user
        if (user == null) {
            throw new RuntimeException("User not found with id: " + userId);
        }

        if (name != null) user.setName(name);
        if (email != null) user.setEmail(email);
        if (phoneNo != null) user.setPhoneNo(phoneNo);
        if (password != null) user.setPassword(password);

        return userService.createUser(user);
    }

}
