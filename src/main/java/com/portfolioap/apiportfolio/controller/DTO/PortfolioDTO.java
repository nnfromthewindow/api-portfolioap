package com.portfolioap.apiportfolio.controller.DTO;

import java.util.List;

import com.portfolioap.apiportfolio.model.BannerImage;
import com.portfolioap.apiportfolio.model.Portfolio;
import com.portfolioap.apiportfolio.model.Users;

public class PortfolioDTO {
	
	private String username;
	
	private String bannerImage;
	
	//private AvatarImage avatarImage;

	private List<NetworkDTO> network;

	public PortfolioDTO(Users user, BannerImage bannerImage, List<NetworkDTO> network) {
	
		this.username = user.getUsername();
		this.bannerImage = bannerImage.getImage();
		this.network = network;
	}

	public String getUsername() {
		return username;
	}

	public String getBannerImage() {
		return bannerImage;
	}

	public List<NetworkDTO> getNetwork() {
		return network;
	}


	
	
	
	
	/*
	public PortfolioDTO(Portfolio portfolio) {
		super();
		this.id = portfolio.getId();
		this.bannerImage = portfolio.getBannerImage();
		
		if (portfolio.getNetwork() != null && !portfolio.getNetwork().isEmpty()) {
			this.network = portfolio.getNetwork().stream().map(NetworkDTO::new).collect(Collectors.toList());
		}
	}
*/

}
