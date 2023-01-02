package com.portfolioap.apiportfolio.controller.form;

import java.util.Optional;

import com.portfolioap.apiportfolio.model.AvatarImage;
import com.portfolioap.apiportfolio.model.Users;

public class AvatarImageForm {

	private String image;
	
	private String userUsername;
	
	

	public AvatarImageForm(String image, String userUsername) {
	
		this.image = image;
		this.userUsername = userUsername;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	
	public  AvatarImage convert(Optional<Users>user) {
		return new AvatarImage(image, user);
	}
}
