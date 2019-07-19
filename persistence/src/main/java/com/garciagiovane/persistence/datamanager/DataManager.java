package com.garciagiovane.persistence.datamanager;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.garciagiovane.persistence.entity.Functionality;
import com.garciagiovane.persistence.entity.Role;
import com.garciagiovane.persistence.entity.StatusRole;
import com.garciagiovane.persistence.entity.User;
import com.garciagiovane.persistence.respositories.UserRepository;

@Component
public class DataManager implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {		
		saveUsers(); 
		showUsers();
		
	}
	
	private void showUsers() {		
		userRepository.findByName("Giovane").ifPresent(user -> System.out.println("User name: " + user.getName()));
		userRepository.findByNameContaining("arc").ifPresent(user -> System.out.println("User name: " + user.getName()));		
		userRepository.findByEmail("vic@vic.com").ifPresent(user -> System.out.println("User name: " + user.getEmail()));
	}
	
	private void saveUsers() {
		Role role1 = new Role("Student", StatusRole.ACTIVE, Arrays.asList(new Functionality("Read")));
		Role role2 = new Role("Admin", StatusRole.ACTIVE, Arrays.asList(new Functionality("Write")));
		Role role3 = new Role("Student", StatusRole.ACTIVE, Arrays.asList(new Functionality("Read")));
		Role role4 = new Role("Student", StatusRole.ACTIVE, Arrays.asList(new Functionality("Read")));
		
		userRepository.save(new User("Giovane", "giovane@giovane.com", Arrays.asList(role1)));
		userRepository.save(new User("Vic", "vic@vic.com", Arrays.asList(role2)));
		userRepository.save(new User("João", "joão@joão.com", Arrays.asList(role3)));
		userRepository.save(new User("Marcela", "marcela@marcela.com", Arrays.asList(role4)));
	}
}
