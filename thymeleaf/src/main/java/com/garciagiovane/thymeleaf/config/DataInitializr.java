package com.garciagiovane.thymeleaf.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.garciagiovane.thymeleaf.entity.User;
import com.garciagiovane.thymeleaf.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {
			createUser("Giovane", "giovane.garcia09@gmail.com");
			createUser("Victória", "vicmarqes@gmail.com");
			createUser("Renata", "re.santos@gmail.com");

			System.out.println("Users saved successfully");
		}
		
		System.out.println(userRepository.findByNameLike("Vic").getName());
		System.out.println(userRepository.findByEmail("giovane.garcia09@gmail.com").getName());
		System.out.println("Query ignore case: " + userRepository.findByNameIgnoreCase("renata").getName());
		System.out.println("Custom query: " + userRepository.findByUsername("Giovane").getName());		
	}
	
	private void createUser(String name, String email) {
		userRepository.save(new User(name, email));
	}
	
}
