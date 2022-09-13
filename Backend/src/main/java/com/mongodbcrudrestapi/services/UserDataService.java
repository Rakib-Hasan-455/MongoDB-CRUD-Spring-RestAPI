package com.mongodbcrudrestapi.services;

import com.mongodbcrudrestapi.dao.UserRepository;
import com.mongodbcrudrestapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {

    @Autowired
    private UserRepository userRepository;

    public User getOneUser(int id) {
        return userRepository.findById(id);
    }

    public User insertUserData(User user) {
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User updateOneUser(User user) {
        return userRepository.save(user);
    }

    public void deleteOneUser(int id) {
        userRepository.deleteById(id);
    }
}
