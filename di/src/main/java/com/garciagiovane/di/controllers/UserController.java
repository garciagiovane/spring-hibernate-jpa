package com.garciagiovane.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.garciagiovane.di.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		model.addAttribute("usersList", userService.findAll());
		return "user";
	}
	
	@GetMapping("/user/{name}")
	public String getUserByName(Model model, @PathVariable("name") String name) {
		model.addAttribute("user", userService.findByNameIgnoreCase(name));
		return "username";
	}
}
