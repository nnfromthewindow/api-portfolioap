package com.portfolioap.apiportfolio.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ConfirmationToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String confirmationToken;

	private LocalDate createdDate;

	@OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private Users user;

	public ConfirmationToken(){
		
	};
	
	public ConfirmationToken(Users user) {
		this.user = user;
		this.createdDate = LocalDate.now();
		this.confirmationToken = UUID.randomUUID().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	

}
