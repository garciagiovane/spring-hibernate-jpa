package com.garciagiovane.manytomany.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	private String name;
	private String email;	
	@ManyToMany
	private List<Role> roles;
	
	public User() {}
	
	public User(String name, String email, List<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.roles = roles;
	}

	public List<Role> getRole() {
		return roles;
	}
	public void setRole(List<Role> roles) {
		this.roles = roles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
