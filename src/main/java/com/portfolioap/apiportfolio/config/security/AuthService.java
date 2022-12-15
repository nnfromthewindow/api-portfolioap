package com.portfolioap.apiportfolio.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolioap.apiportfolio.model.Users;
import com.portfolioap.apiportfolio.repository.UsersRepository;
@Service
public class AuthService implements UserDetailsService{
	
	@Autowired
	private UsersRepository usersRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = usersRepository.findByUsername(username);
		
		return user.orElseThrow(() -> new UsernameNotFoundException("Datos inválidos"));
	}
	

}
