package com.garciagiovane.persistence.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garciagiovane.persistence.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
