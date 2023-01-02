package com.portfolioap.apiportfolio.controller.form;

import java.util.Optional;

import com.portfolioap.apiportfolio.model.Users;
import com.portfolioap.apiportfolio.model.Welcome;

public class WelcomeForm {
	
	private String message;
	
	private String userUsername;
	
	

	public WelcomeForm(String message, String userUsername) {
	
		this.message = message;
		this.userUsername = userUsername;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public  Welcome convert(Optional<Users>user) {
		return new Welcome(message, user);
	}
}
