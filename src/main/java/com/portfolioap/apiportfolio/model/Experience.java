package com.portfolioap.apiportfolio.model;

import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Experience {

	@Id
	  @GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	
	private String title;
	
	private String subtitle;
	
	private String detail;
	
	private String color;
	
	private String image;

	@ManyToOne
	private Users user;
	
	public Experience() {};

	public Experience(String title, String subtitle, String detail, String color, String image,
			Optional<Users> user) {
	
		this.title = title;
		this.subtitle = subtitle;
		this.detail = detail;
		this.color = color;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
