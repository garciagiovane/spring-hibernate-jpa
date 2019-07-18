package com.garciagiovane.manytomany.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	@Enumerated(EnumType.STRING)
	private StatusRole statusRole;
	
	public Role() {}

	public Role(String name, StatusRole statusRole) {
		super();
		this.name = name;
		this.statusRole = statusRole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StatusRole getStatus() {
		return statusRole;
	}

	public void setStatus(StatusRole status) {
		this.statusRole = status;
	}
}
