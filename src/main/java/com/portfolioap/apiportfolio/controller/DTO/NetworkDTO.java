package com.portfolioap.apiportfolio.controller.DTO;

import com.portfolioap.apiportfolio.model.Network;

public class NetworkDTO {

	private String id;
	
	private String title;
	
	private String icon;
	
	private String link;

	private String userUsername;
	
	public NetworkDTO() {};

	public NetworkDTO(Network network) {

		this.id = network.getId().toString();
		this.title = network.getTitle();
		this.icon = network.getIcon();
		this.link = network.getLink();
		this.userUsername = network.getUser().getUsername();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getIcon() {
		return icon;
	}

	public String getLink() {
		return link;
	}

	public String getUser() {
		return userUsername;
	}
	
}
