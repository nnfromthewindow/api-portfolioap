package com.portfolioap.apiportfolio.model;

import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Skill {
	@Id
	  @GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	
	private String title;
	
	private Integer percentaje;
	
	private String icon;
	
	private String color;
	
	@ManyToOne
	private Users user;

	public Skill() {};
	
	public Skill(String title, Integer percentaje, String icon, String color, Optional<Users> user) {
	
		this.title = title;
		this.percentaje = percentaje;
		this.icon = icon;
		this.color = color;
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

	public Integer getPercentaje() {
		return percentaje;
	}

	public void setPercentaje(Integer percentaje) {
		this.percentaje = percentaje;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	

}
