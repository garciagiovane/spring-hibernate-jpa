package com.garciagiovane.primeiroprojeto.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.garciagiovane.primeiroprojeto.entity.User;
import com.garciagiovane.primeiroprojeto.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {
			createUser("Giovane", "giovane.garcia09@gmail.com");
			createUser("Vict�ria", "vicmarqes@gmail.com");
			createUser("Renata", "re.santos@gmail.com");

			System.out.println("Users saved successfully");
		}
		
		System.out.println(findByName("Giovane").getName());
		System.out.println("JPQL query: "+userRepository.findByNotAColumnNameJPQL("Victória").getName());
		System.out.println("Native sql query: " + userRepository.findByNotAColumnNameNativeSQL("Renata").getName());
		System.out.println("Native sql query like: " + userRepository.findByNotAColumnNameLike("V").getName());
		System.out.println("Native sql query ignore case: " + userRepository.findByNameIgnoreCase("victória").getName());
		Optional<User> user = userRepository.findById(0L);
		user.ifPresent(u -> deleteUser(u));

		User alteredUser = userRepository.getOne(1L);
		alteredUser.setName("Giovane Pacheco");
		alterUser(alteredUser);

	}

	private void createUser(String name, String email) {
		userRepository.save(new User(name, email));
	}

	private void deleteUser(User user) {
		userRepository.delete(user);
	}

	private void alterUser(User user) {
		userRepository.save(user);
	}
	
	private User findByName(String name) {
		return userRepository.findByName(name);
	}
}
