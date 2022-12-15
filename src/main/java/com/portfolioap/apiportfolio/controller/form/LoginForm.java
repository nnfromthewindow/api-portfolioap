package com.portfolioap.apiportfolio.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.validation.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Authentication convert() {
		return new UsernamePasswordAuthenticationToken(username, password);
	}
	 
	
}
