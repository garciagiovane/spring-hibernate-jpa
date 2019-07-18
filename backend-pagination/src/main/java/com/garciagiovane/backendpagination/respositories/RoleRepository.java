package com.garciagiovane.backendpagination.respositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garciagiovane.backendpagination.entity.Role;
import com.garciagiovane.backendpagination.entity.StatusRole;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Page<Role> findAll(Pageable pageable);
	List<Role> findByStatusRole(StatusRole statusRole);
}