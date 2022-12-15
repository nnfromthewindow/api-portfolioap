package com.portfolioap.apiportfolio.controller.DTO;

import com.portfolioap.apiportfolio.model.BannerImage;

public class BannerImageDTO {

	private String id;
	
	private String image;

	private String userUsername;

	public BannerImageDTO() {};
	
	public BannerImageDTO(BannerImage bannerImage) {
		super();
		this.id = bannerImage.getId().toString();
		this.image = bannerImage.getImage();
		this.userUsername = bannerImage.getUser().getUsername();
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
