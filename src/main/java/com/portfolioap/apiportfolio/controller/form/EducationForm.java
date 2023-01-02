package com.portfolioap.apiportfolio.controller.form;

import java.util.Optional;

import com.portfolioap.apiportfolio.model.Education;
import com.portfolioap.apiportfolio.model.Users;

public class EducationForm {

	private String title;
	
	private String subtitle;
	
	private String detail;
	
	private String color;
	
	private String image;
	
	private String userUsername;
	
	

	public EducationForm(String title, String subtitle, String detail, String color, String image,
			String userUsername) {
	
		this.title = title;
		this.subtitle = subtitle;
		this.detail = detail;
		this.color = color;
		this.image = image;
		this.userUsername = userUsername;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
	
	public  Education convert(Optional<Users>user) {
		return new Education(title, subtitle, detail, color, image, user);
	}

}
