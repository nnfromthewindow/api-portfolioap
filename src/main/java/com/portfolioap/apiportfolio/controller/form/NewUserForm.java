package com.portfolioap.apiportfolio.controller.form;

import java.util.List;

import com.portfolioap.apiportfolio.model.UsersProfile;

import jakarta.validation.constraints.NotEmpty;

public class NewUserForm {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private List<UsersProfile> roleId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UsersProfile> getRoleId() {
		return roleId;
	}

	public void setRoleId(List<UsersProfile> roleId) {
		this.roleId = roleId;
	}

	
}
