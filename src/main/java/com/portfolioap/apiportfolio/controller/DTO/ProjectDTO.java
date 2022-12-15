package com.portfolioap.apiportfolio.controller.DTO;

import com.portfolioap.apiportfolio.model.Project;

public class ProjectDTO {
	
	private String id;
	
	private String title;
	
	private String description;
	
	private String link;
	
	private String image;

	private String userUsername;

	public ProjectDTO() {}
	
	public ProjectDTO(Project project) {
		
		this.id = project.getId().toString();
		this.title = project.getTitle();
		this.description = project.getDescription();
		this.link = project.getLink();
		this.image = project.getImage();
		this.userUsername = project.getUser().getUsername();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getLink() {
		return link;
	}

	public String getImage() {
		return image;
	}

	public String getUser() {
		return userUsername;
	}
	
	
	
}
