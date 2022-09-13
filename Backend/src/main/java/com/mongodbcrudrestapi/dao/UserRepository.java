package com.mongodbcrudrestapi.dao;

import com.mongodbcrudrestapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {

    User findByEmail(String email);

    User findById(int id);
}
