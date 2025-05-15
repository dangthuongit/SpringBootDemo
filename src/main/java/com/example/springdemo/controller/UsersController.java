package com.example.springdemo.controller;

import com.example.springdemo.model.Users;
import com.example.springdemo.repository.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Users> getAllUserss() {
        return usersRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users getUsersById(@PathVariable("id") ObjectId id) {
        return usersRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyUsersById(@PathVariable("id") ObjectId id, @RequestBody Users users) {
        users.set_id(id);
        usersRepository.save(users);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Users createUsers(@RequestBody Users users) {
        users.set_id(ObjectId.get());
        usersRepository.save(users);
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUsers(@PathVariable ObjectId id) {
        usersRepository.delete(usersRepository.findBy_id(id));
    }

    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public Users getUserByUsername(@PathVariable("username") String username) {
        return usersRepository.findByUsername(username);
    }
}
