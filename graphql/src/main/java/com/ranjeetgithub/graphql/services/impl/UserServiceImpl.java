package com.ranjeetgithub.graphql.services.impl;

import com.ranjeetgithub.graphql.entities.User;
import com.ranjeetgithub.graphql.repository.UserRepository;
import com.ranjeetgithub.graphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not present in the database"));
    }

    @Override
    public User updateUserById(int userId,User user) {
        User user1 = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not present in the database"));
        user1.setName(user.getName());
        user1.setPhoneNo(user.getPhoneNo());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        userRepository.save(user1);
        return user1;
    }

    @Override
    public boolean deleteUserById(int userId) {
         userRepository.deleteById(userId);
         return true;
    }
}
