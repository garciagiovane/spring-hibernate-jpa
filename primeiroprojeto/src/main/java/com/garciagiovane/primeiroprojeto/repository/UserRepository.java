package com.garciagiovane.primeiroprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.garciagiovane.primeiroprojeto.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	/*findBy{nome_da_coluna}*/
	User findByName(String name);
	
	/*User is the class name*/
	@Query("SELECT u FROM User u WHERE u.name = :name")
	User findByNotAColumnNameJPQL(@Param("name") String name);
	
	@Query(value = "SELECT * FROM user u WHERE u.name = :name", nativeQuery = true)
	User findByNotAColumnNameNativeSQL(@Param("name") String name);
	
	@Query(value = "SELECT * FROM user u WHERE u.name like :name%", nativeQuery = true)
	User findByNotAColumnNameLike(@Param("name") String name);
	
	User findByNameIgnoreCase(String name);
}
