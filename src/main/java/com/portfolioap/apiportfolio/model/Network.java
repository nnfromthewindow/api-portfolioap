package com.portfolioap.apiportfolio.model;

import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Network {

	@Id
	  @GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	
	private String title;
	
	private String icon;
	
	private String link;
	
	@ManyToOne
	private Users user;
	
	public Network() {};

	public Network(String title, String icon, String link, Optional<Users> user) {
	
		this.title = title;
		this.icon = icon;
		this.link = link;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}
