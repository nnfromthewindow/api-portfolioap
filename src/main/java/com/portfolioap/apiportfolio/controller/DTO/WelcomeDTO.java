package com.portfolioap.apiportfolio.controller.DTO;

import com.portfolioap.apiportfolio.model.Welcome;

public class WelcomeDTO {

	private String id;
	
	private String message;
	
	private String userUsername;
	
	public WelcomeDTO() {}

	public WelcomeDTO(Welcome welcome) {
		
		this.id = welcome.getId().toString();
		this.message = welcome.getMessage();
		this.userUsername = welcome.getUser().getUsername();
	}

	public String getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public String getUser() {
		return userUsername;
	}
	
	
	
	
}
