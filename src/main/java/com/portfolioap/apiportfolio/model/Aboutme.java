package com.portfolioap.apiportfolio.model;

import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Aboutme {

	@Id
	  @GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	
	private String message;
	@ManyToOne
	private Users user;

	public Aboutme() {}

	public Aboutme(String message, Optional<Users> user) {
		
		this.message = message;
		user.ifPresent(u -> this.user = u);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
	
}
