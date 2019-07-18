package com.garciagiovane.manytoone.datamanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.garciagiovane.manytoone.entity.Role;
import com.garciagiovane.manytoone.entity.User;
import com.garciagiovane.manytoone.respositories.RoleRepository;
import com.garciagiovane.manytoone.respositories.UserRepository;

@Component
public class DataManager implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		saveRoles();
		saveUsers();
		
	}
	
	private void saveRoles() {
		roleRepository.save(new Role("Admin"));
		roleRepository.save(new Role("Student"));
	}
	
	private void saveUsers() {
		Role admin = roleRepository.getOne(1L);
		Role student = roleRepository.getOne(2L);
		
		userRepository.save(new User("Giovane", "giovane@giovane.com", admin));
		userRepository.save(new User("Vic", "vic@vic.com", student));
	}
}
