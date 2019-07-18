package com.garciagiovane.manytomany.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garciagiovane.manytomany.entity.Role;
import com.garciagiovane.manytomany.entity.StatusRole;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	List<Role> findByStatusRole(StatusRole statusRole);	
}
