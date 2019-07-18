package com.garciagiovane.backendpagination.datamanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.garciagiovane.backendpagination.entity.Role;
import com.garciagiovane.backendpagination.entity.StatusRole;
import com.garciagiovane.backendpagination.respositories.RoleRepository;

@Component
public class DataManager implements ApplicationListener<ContextRefreshedEvent>{	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		saveRoles();
		paginate();
		findByStatus(StatusRole.ACTIVE);
	}
	
	private void saveRoles() {
		for (int i = 0; i < 500; i++) {
			roleRepository.save(new Role("Admin", StatusRole.ACTIVE));
		}
		for (int i = 0; i < 500; i++) {
			roleRepository.save(new Role("Student", StatusRole.INACTIVE));
		}		
	}
	
	private void paginate() {
		PageRequest pageable = PageRequest.of(10, 10);
		roleRepository.findAll(pageable).forEach(role -> System.out.println(role.getName()));
	}
	
	private void findByStatus(StatusRole statusRole) {
		System.out.println("Status " + statusRole.name());
		roleRepository.findByStatusRole(statusRole).forEach(role -> System.out.println(role.getName()));
	}
}
