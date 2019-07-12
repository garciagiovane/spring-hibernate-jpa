package com.garciagiovane.webpages.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.garciagiovane.webpages.entity.User;

@RestController
public class UserController {
	
	@GetMapping("users")
	public List<User> getUser() {
		List<User> users = new ArrayList<User>();
		users.add(new User("Giovane", "teste@teste.com.br"));
		users.add(new User("Victória", "vic@teste.com.br"));
		return users;
	}
	
	@GetMapping("user/{name}")
	public User getUserByName(@PathVariable String name) {
		List<User> users = new ArrayList<User>();
		users.add(new User(name, name+"@teste.com.br"));
		return new User(name, name+"@teste.com.br");
	}
	
	@PostMapping("/user")
	public User newUser(@RequestBody User user) {
		return user;
	}
}
