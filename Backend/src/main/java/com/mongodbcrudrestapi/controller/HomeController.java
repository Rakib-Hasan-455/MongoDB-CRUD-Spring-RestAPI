package com.mongodbcrudrestapi.controller;

import com.mongodbcrudrestapi.entity.User;
import com.mongodbcrudrestapi.services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin
public class HomeController {
    @Autowired
    private UserDataService userDataService;

    @PostMapping
    public ResponseEntity<User> saveOne(@RequestBody User user) {
        return ResponseEntity.ok(userDataService.insertUserData(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userDataService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userDataService.getOneUser(id));
    }

    @PutMapping
    public ResponseEntity<User> updateOneUser(@RequestBody User user) {
        return ResponseEntity.ok(userDataService.updateOneUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        userDataService.deleteOneUser(id);
        return ResponseEntity.ok("Delete Successful!");
    }
}
