package com.mongodbcrudrestapi.dao;

import com.mongodbcrudrestapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findById(int id);

    void deleteById(int id);
}
