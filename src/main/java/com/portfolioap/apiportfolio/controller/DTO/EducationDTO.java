package com.portfolioap.apiportfolio.controller.DTO;

import com.portfolioap.apiportfolio.model.Education;

public class EducationDTO {

	private String id;
	
	private String title;
	
	private String subtitle;
	
	private String detail;
	
	private String color;
	
	private String image;

	private String userUsername;

	public EducationDTO() {};
	
	public EducationDTO(Education education) {
		
		this.id = education.getId().toString();
		this.title = education.getTitle();
		this.subtitle = education.getSubtitle();
		this.detail = education.getDetail();
		this.color = education.getColor();
		this.image = education.getImage();
		this.userUsername = education.getUser().getUsername();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public String getDetail() {
		return detail;
	}

	public String getColor() {
		return color;
	}

	public String getImage() {
		return image;
	}

	public String getUser() {
		return userUsername;
	}
	
	
	
}
