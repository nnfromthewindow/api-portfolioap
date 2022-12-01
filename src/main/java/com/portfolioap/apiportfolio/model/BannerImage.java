package com.portfolioap.apiportfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity		
public class BannerImage {

	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String link;
	@Lob
	private byte[] linkBlob;
	
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public byte[] getLinkBlob() {
		return linkBlob;
	}

	public void setLinkBlob(byte[] linkBlob) {
		this.linkBlob = linkBlob;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
