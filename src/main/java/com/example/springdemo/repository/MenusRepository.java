package com.example.springdemo.repository;

import com.example.springdemo.model.Menus;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenusRepository extends MongoRepository<Menus, String> {
    Menus findBy_id(ObjectId id);
}