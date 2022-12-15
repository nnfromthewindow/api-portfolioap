package com.portfolioap.apiportfolio.controller.form;

import java.util.Optional;

import com.portfolioap.apiportfolio.model.Skill;
import com.portfolioap.apiportfolio.model.Users;

public class SkillForm {

	private String title;
	
	private Integer percentaje;
	
	private String icon;
	
	private String color;
	
	private String userUsername;

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

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	
	public Skill convert(Optional<Users>user) {
		return new Skill(title, percentaje, icon, color, user);
	}
}
