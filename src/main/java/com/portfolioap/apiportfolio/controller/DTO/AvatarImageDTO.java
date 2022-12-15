package com.portfolioap.apiportfolio.controller.DTO;

import com.portfolioap.apiportfolio.model.AvatarImage;

public class AvatarImageDTO {
	
	private String id;
	
	private String image;


	private String userUsername;

	public AvatarImageDTO() {};
	public AvatarImageDTO(AvatarImage avatarImage) {
	
		this.id = avatarImage.getId().toString();
		this.image = avatarImage.getImage();
		this.userUsername = avatarImage.getUser().getUsername();
	}
	public String getId() {
		return id;
	}
	public String getImage() {
		return image;
	}
	public String getUser() {
		return userUsername;
	}
	
	
}
