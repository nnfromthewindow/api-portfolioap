package com.portfolioap.apiportfolio.config.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolioap.apiportfolio.controller.form.NewUserForm;
import com.portfolioap.apiportfolio.exception.ExistingUserException;
import com.portfolioap.apiportfolio.model.ConfirmationToken;
import com.portfolioap.apiportfolio.model.Roles;
import com.portfolioap.apiportfolio.model.Users;
import com.portfolioap.apiportfolio.repository.RolesRepository;
import com.portfolioap.apiportfolio.repository.UsersRepository;
import com.portfolioap.apiportfolio.service.ConfirmationTokenService;
import com.portfolioap.apiportfolio.service.EmailService;
@Service
public class AuthService implements UserDetailsService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	@Autowired
	private EmailService emailSenderService;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Optional<Users> user = usersRepository.findByUsername(username);
		
		return user.orElseThrow(() -> new UsernameNotFoundException("Datos inválidos"));
	}
	
	public void signUpUser(NewUserForm newUser) {
		
		 Optional<Users> existingUser = usersRepository.findByUsername(newUser.getUsername());

		 if(existingUser.isPresent() ) {
			 throw new ExistingUserException("El nombre de usuario ya existe, intente otro nombre de usuario"); 
		 }
	
		 BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		
		 String encryptedPassword = bc.encode(newUser.getPassword());

		 newUser.setPassword(encryptedPassword);
		
		Users user = new Users(newUser.getUsername(),newUser.getPassword(),newUser.getEmail());
		Roles role = new Roles("ROLE_USER",user);
		
		user.setRole(Collections.singletonList(role));
		 usersRepository.save(user);

		 ConfirmationToken confirmationToken = new ConfirmationToken(user);

		confirmationTokenService.saveConfirmationToken(confirmationToken);

		sendConfirmationMail(newUser.getEmail(), confirmationToken.getConfirmationToken());
		 


	}
	
	public void confirmUser(ConfirmationToken confirmationToken) {

		  final Users user = confirmationToken.getUser();

		  user.setEnabled(true);

		  usersRepository.save(user);

		  confirmationTokenService.deleteConfirmationToken(confirmationToken.getId());

		}
	
	public void sendConfirmationMail(String userMail, String token) {

		final SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(userMail);
		mailMessage.setSubject("Mail de Confirmacion! Activa tu Cuenta de Portfolio!");
		mailMessage.setFrom("nuccelli87@gmail.com");
		mailMessage.setText(
				"Gracias por registrarte!! Para activar tu cuenta hace click en el siguiente enlace: " + "http://localhost:8080/sign-up/confirm?token="
						+ token);
		
		emailSenderService.sendEmail(mailMessage);
	}
	
	

}
