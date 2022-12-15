package com.portfolioap.apiportfolio.controller.form;

import java.util.Optional;

import com.portfolioap.apiportfolio.model.Aboutme;
import com.portfolioap.apiportfolio.model.Users;

public class AboutmeForm {

	private String message;
	
	private String userUsername;

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
	
	public  Aboutme convert(Optional<Users>user) {
		return new Aboutme(message, user);
	}

}
