package com.portfolioap.apiportfolio.controller.DTO;

import com.portfolioap.apiportfolio.model.Skill;

public class SkillDTO {
	
	private String id;
	
	private String title;
	
	private Integer percentaje;
	
	private String icon;
	
	private String color;

	private String userUsername;
	
	public SkillDTO() {}

	public SkillDTO(Skill skill) {
		
		this.id = skill.getId().toString();
		this.title = skill.getTitle();
		this.percentaje = skill.getPercentaje();
		this.icon = skill.getIcon();
		this.color = skill.getColor();
		this.userUsername = skill.getUser().getUsername();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getPercentaje() {
		return percentaje;
	}

	public String getIcon() {
		return icon;
	}

	public String getColor() {
		return color;
	}

	public String getUser() {
		return userUsername;
	}
	
	
	

}
