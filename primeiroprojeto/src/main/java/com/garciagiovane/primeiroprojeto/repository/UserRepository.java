package com.garciagiovane.primeiroprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garciagiovane.primeiroprojeto.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
