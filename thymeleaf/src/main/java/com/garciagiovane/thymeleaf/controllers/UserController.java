package com.garciagiovane.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.garciagiovane.thymeleaf.repository.UserRepository;

@Controller
public class UserController {
	
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		model.addAttribute("usersList", userRepository.findAll());
		return "user";
	}
	
	@GetMapping("/user/{name}")
	public String getUserByName(Model model, @PathVariable("name") String name) {
		model.addAttribute("user", userRepository.findByNameIgnoreCase(name));
		return "username";
	}
}
