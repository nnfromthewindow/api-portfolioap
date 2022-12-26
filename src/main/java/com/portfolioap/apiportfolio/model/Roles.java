package com.portfolioap.apiportfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Roles {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String role;
	
	
	public Roles( ) {
	
	}

	public Roles( String role) {

		this.role = role;
	}
	

	public Roles(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	




}
