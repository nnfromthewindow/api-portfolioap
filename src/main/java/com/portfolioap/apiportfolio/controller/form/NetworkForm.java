package com.portfolioap.apiportfolio.controller.form;

import java.util.Optional;

import com.portfolioap.apiportfolio.model.Network;
import com.portfolioap.apiportfolio.model.Users;

public class NetworkForm {

	private String title;
	
	private String icon;
	
	private String link;
	
	private String userUsername;

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

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public Network convert(Optional<Users>user) {
		return new Network(title,icon,link,user);
	}

}
