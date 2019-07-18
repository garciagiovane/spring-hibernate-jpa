package com.garciagiovane.manytomany.datamanager;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.garciagiovane.manytomany.entity.Role;
import com.garciagiovane.manytomany.entity.StatusRole;
import com.garciagiovane.manytomany.entity.User;
import com.garciagiovane.manytomany.respositories.RoleRepository;
import com.garciagiovane.manytomany.respositories.UserRepository;

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
		roleRepository.save(new Role("Admin", StatusRole.ACTIVE));
		roleRepository.save(new Role("Student", StatusRole.INACTIVE));
	}
	
	private void saveUsers() {
		List<Role> unavailableRoles = getRolesByStatus(StatusRole.INACTIVE);
		
		userRepository.save(new User("Giovane", "giovane@giovane.com", roleRepository.findAll()));
		userRepository.save(new User("Vic", "vic@vic.com", unavailableRoles));
	}
	
	private List<Role> getRolesByStatus(StatusRole statusRole){
		return Collections.unmodifiableList(roleRepository.findByStatusRole(statusRole));
	}
}
