package com.portfolioap.apiportfolio.controller.form;

import java.util.Optional;

import com.portfolioap.apiportfolio.model.BannerImage;
import com.portfolioap.apiportfolio.model.Users;

public class BannerImageForm {
	
	private String image;
	
	private String userUsername;

	public String getImage() {
		return image;
	}

	public String getUserUsername() {
		return userUsername;
	}
	
	public  BannerImage convert(Optional<Users>user) {
		return new BannerImage(image, user);
	}

}
