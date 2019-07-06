package com.garciagiovane.projetomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.garciagiovane.projetomongo.entity.User;

public interface UserRepository extends MongoRepository<User, String>{
	User findByName(String name);
	User findByEmail(String email);
	User findByNameIgnoreCase(String name);
}
