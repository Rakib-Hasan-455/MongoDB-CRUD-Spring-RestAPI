package com.mongodbcrudrestapi.controller;

import com.mongodbcrudrestapi.entity.User;
import com.mongodbcrudrestapi.services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class HomeController {
    @Autowired
    private UserDataService userDataService;

    @PostMapping("/users")
    public User saveOne(@RequestBody User user) {
        return userDataService.insertUserData(user);
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userDataService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userDataService.getOneUser(id);
    }

    @PutMapping("/users")
    public User updateOneUser(@RequestBody User user) {
        return userDataService.updateOneUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userDataService.deleteOneUser(id);
    }
}
