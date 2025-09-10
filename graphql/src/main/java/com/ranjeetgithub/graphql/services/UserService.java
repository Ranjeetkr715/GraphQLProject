package com.ranjeetgithub.graphql.services;

import com.ranjeetgithub.graphql.entities.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);

    public List<User> getAllUser();

    public User getUserById(int userId);

    public User updateUserById(int userId,User user);

    public boolean deleteUserById(int userId);

}
