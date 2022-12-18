package com.portfolioap.apiportfolio.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Users implements UserDetails {

	private static final long serialVersionUID = 1L;

		@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
	
	  private String username;

	  private String password;
	  
	  private String email;
	  
	  private Boolean locked = false;
	  
	  private Boolean enabled = false;
	  @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	  private List<Roles> roles = new ArrayList<>(); 
	  
	  public Users() {
		  
	  };
	  

	public Users(String username, String password, String email) {
	
		this.username = username;
		this.password = password;
		this.email=email;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
	
	@Override
	public String getPassword() {

		return this.password;
	}

	@Override
	public String getUsername() {

		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return enabled;
	}



	public List<Roles> getRole() {
		return roles;
	}


	public void setRole(List<Roles> roleId) {
		this.roles = roleId;
	}


	public Boolean getLocked() {
		return locked;
	}


	public void setLocked(Boolean locked) {
		this.locked = locked;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	
	  
	
}
