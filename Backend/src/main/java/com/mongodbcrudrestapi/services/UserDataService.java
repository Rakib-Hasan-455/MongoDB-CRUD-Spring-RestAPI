package com.mongodbcrudrestapi.services;

import com.mongodbcrudrestapi.dao.UserRepository;
import com.mongodbcrudrestapi.entity.User;
import com.mongodbcrudrestapi.services.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    @Autowired
    private UserRepository userRepository;

    public User getOneUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found By ID = " + id));
        return user;
    }

    public User insertUserData(User user) {
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User updateOneUser(User user) {
        getOneUser(user.getId());
        return userRepository.save(user);
    }

    public void deleteOneUser(int id) {
        getOneUser(id);
        userRepository.deleteById(id);
    }
}
