package com.garciagiovane.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garciagiovane.di.entity.User;
import com.garciagiovane.di.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findByNameIgnoreCase(String name) {
		return userRepository.findByNameIgnoreCase(name);
	}
}
