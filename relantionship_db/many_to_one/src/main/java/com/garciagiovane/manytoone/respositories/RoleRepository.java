package com.garciagiovane.manytoone.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garciagiovane.manytoone.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
