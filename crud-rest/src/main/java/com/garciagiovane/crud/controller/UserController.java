package com.garciagiovane.crud.controller;

import com.garciagiovane.crud.entity.User;
import com.garciagiovane.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @PostMapping("")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("")
    public User update(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable long id){
        userRepository.deleteById(id);
        return "{\"message\":\"user deleted\"}";
    }
}
