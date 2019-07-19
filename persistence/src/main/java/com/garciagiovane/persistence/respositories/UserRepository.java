package com.garciagiovane.persistence.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.garciagiovane.persistence.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByName(String name);	
	
	Optional<User> findByNameContaining(String name);
	
	@Query("SELECT u FROM User u WHERE u.email LIKE %:email%")
	Optional<User> findByEmail(@Param("email") String email);
}
