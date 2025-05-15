package com.example.springdemo.repository;

import com.example.springdemo.model.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users,String> {
    Users findBy_id(ObjectId id);
    Users findByUsername(String username);
}
