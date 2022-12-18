package com.portfolioap.apiportfolio.controller.form;

import jakarta.validation.constraints.NotEmpty;


public class NewUserForm {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;

	@NotEmpty
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
