package com.portfolioap.apiportfolio.controller.form;

import java.util.Optional;

import com.portfolioap.apiportfolio.model.Project;
import com.portfolioap.apiportfolio.model.Users;

public class ProjectForm {

	private String title;
	
	private String description;
	
	private String link;
	
	private String image;
	
	private String userUsername;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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
	
	public Project convert(Optional<Users>user) {
		return new Project(title, description, link, image, user);
	}
}
