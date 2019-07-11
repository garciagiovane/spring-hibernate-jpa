package com.garciagiovane.di.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.garciagiovane.di.entity.User;

public interface UserRepository extends MongoRepository<User, String>{
	User findByNameLike(String name);
	User findByEmail(String email);
	User findByNameIgnoreCase(String name);
	
	@Query("{'name' : ?0 }")
	User findByUsername(String name);
}
