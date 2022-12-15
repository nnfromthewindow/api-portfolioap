package com.portfolioap.apiportfolio.model;

import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Project {
	@Id
	  @GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	
	private String title;
	
	private String description;
	
	private String link;
	
	private String image;

	@ManyToOne
	private Users user;
	
	public Project() {};

	public Project(String title, String description, String link, String image, Optional<Users> user) {
		
		this.title = title;
		this.description = description;
		this.link = link;
		this.image = image;
		user.ifPresent(u -> this.user = u);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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


	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}
