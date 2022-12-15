package com.portfolioap.apiportfolio.controller.DTO;

import com.portfolioap.apiportfolio.model.Aboutme;

public class AboutmeDTO {
	
	private String id;
	
	private String message;

	private String userUsername;

	public AboutmeDTO() {};
	
	public AboutmeDTO(Aboutme aboutme) {
		
		this.id = aboutme.getId().toString();
		this.message = aboutme.getMessage();
		this.userUsername = aboutme.getUser().getUsername();
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
