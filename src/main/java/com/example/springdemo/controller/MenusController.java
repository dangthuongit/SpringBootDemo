package com.example.springdemo.controller;

import com.example.springdemo.model.Menus;
import com.example.springdemo.repository.MenusRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenusController {
    @Autowired
    private MenusRepository menusRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Menus> getAllMenus() {
        return menusRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Menus getMenuById(@PathVariable("id") ObjectId id) {
        return menusRepository.findBy_id(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Menus createMenu(@RequestBody Menus menu) {
        menu.set_id(ObjectId.get());
        menusRepository.save(menu);
        return menu;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyMenuById(@PathVariable("id") ObjectId id, @RequestBody Menus menu) {
        menu.set_id(id);
        menusRepository.save(menu);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMenu(@PathVariable ObjectId id) {
        menusRepository.delete(menusRepository.findBy_id(id));
    }
}