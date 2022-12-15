package com.portfolioap.apiportfolio.controller.DTO;

import com.portfolioap.apiportfolio.model.Experience;

public class ExperienceDTO {

	private String id;
	
	private String title;
	
	private String subtitle;
	
	private String detail;
	
	private String color;
	
	private String image;

	private String userUsername;

	public ExperienceDTO() {};
	
	public ExperienceDTO(Experience experience) {
		
		this.id = experience.getId().toString();
		this.title = experience.getTitle();
		this.subtitle = experience.getSubtitle();
		this.detail = experience.getDetail();
		this.color = experience.getColor();
		this.image = experience.getImage();
		this.userUsername = experience.getUser().getUsername();
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
