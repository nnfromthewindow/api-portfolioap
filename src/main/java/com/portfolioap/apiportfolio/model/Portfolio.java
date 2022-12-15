package com.portfolioap.apiportfolio.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Portfolio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Users userId;
	@ManyToOne
	private BannerImage bannerImage;
	//@ManyToOne
	//private AvatarImage avatarImage;
	@OneToMany(mappedBy = "id")
	private List<Network> network= new ArrayList<>();
/*	@ManyToOne
	private Welcome welcome;
	@OneToMany
	private List<Aboutme> aboutme= new ArrayList<>();
	@OneToMany
	private List<Education> education= new ArrayList<>();
	@OneToMany
	private List<Experience> experience= new ArrayList<>();
	@OneToMany
	private List<Skill> skill= new ArrayList<>();
	@OneToMany
	private List<Project> project= new ArrayList<>();
	*/
	public Portfolio(){}
	public Portfolio(Users userId, BannerImage bannerImage, List<Network> network) {
		
		this.userId = userId;
		this.bannerImage = bannerImage;
		this.network = network;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Users getUser() {
		return userId;
	}
	public void setUser(Users user) {
		this.userId = user;
	}
	public BannerImage getBannerImage() {
		return bannerImage;
	}
	public void setBannerImage(BannerImage bannerImage) {
		this.bannerImage = bannerImage;
	}
	public List<Network> getNetwork() {
		return network;
	}
	public void setNetwork(List<Network> network) {
		this.network = network;
	}
	
	
/*
	public Portfolio(User user, BannerImage bannerImage, AvatarImage avatarImage, List<Network> network,
			Welcome welcome, List<Aboutme> aboutme, List<Education> education, List<Experience> experience,
			List<Skill> skill, List<Project> project) {
	
		this.user = user;
		this.bannerImage = bannerImage;
		this.avatarImage = avatarImage;
		this.network = network;
		this.welcome = welcome;
		this.aboutme = aboutme;
		this.education = education;
		this.experience = experience;
		this.skill = skill;
		this.project = project;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BannerImage getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(BannerImage bannerImage) {
		this.bannerImage = bannerImage;
	}

	public AvatarImage getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(AvatarImage avatarImage) {
		this.avatarImage = avatarImage;
	}

	public List<Network> getNetwork() {
		return network;
	}

	public void setNetwork(List<Network> network) {
		this.network = network;
	}

	public Welcome getWelcome() {
		return welcome;
	}

	public void setWelcome(Welcome welcome) {
		this.welcome = welcome;
	}

	public List<Aboutme> getAboutme() {
		return aboutme;
	}

	public void setAboutme(List<Aboutme> aboutme) {
		this.aboutme = aboutme;
	}

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public List<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	};
*/
	
}
