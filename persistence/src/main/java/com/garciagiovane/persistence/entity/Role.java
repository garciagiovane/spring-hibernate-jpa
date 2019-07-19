package com.garciagiovane.persistence.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String name;
	@Enumerated(EnumType.STRING)
	private StatusRole statusRole;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Functionality> functionalities;
	
	public Role() {}

	public Role(String name, StatusRole statusRole, List<Functionality> functionalities) {
		super();
		this.name = name;
		this.statusRole = statusRole;
		this.functionalities = functionalities;
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

	public StatusRole getStatusRole() {
		return statusRole;
	}

	public void setStatusRole(StatusRole statusRole) {
		this.statusRole = statusRole;
	}

	public List<Functionality> getFunctionalities() {
		return functionalities;
	}

	public void setFunctionalities(List<Functionality> functionalities) {
		this.functionalities = functionalities;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", statusRole=" + statusRole + "]";
	}
}
