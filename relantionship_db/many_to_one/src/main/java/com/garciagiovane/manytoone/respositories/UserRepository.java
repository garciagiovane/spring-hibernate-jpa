package com.garciagiovane.manytoone.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garciagiovane.manytoone.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
