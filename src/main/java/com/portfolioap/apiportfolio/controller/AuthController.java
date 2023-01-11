package com.portfolioap.apiportfolio.controller;

import java.util.Optional;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolioap.apiportfolio.config.security.AuthService;
import com.portfolioap.apiportfolio.config.security.LoginResponse;
import com.portfolioap.apiportfolio.config.security.RegisterResponse;
import com.portfolioap.apiportfolio.config.security.TokenService;
import com.portfolioap.apiportfolio.controller.form.LoginForm;
import com.portfolioap.apiportfolio.controller.form.NewUserForm;
import com.portfolioap.apiportfolio.model.ConfirmationToken;
import com.portfolioap.apiportfolio.service.ConfirmationTokenService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class AuthController {

	  	@Autowired
	    private  TokenService tokenService;
	  	@Autowired
	    private  AuthenticationManager authenticationManager;
	  	@Autowired
	    private  AuthService userService;
	  	@Autowired
	    private ConfirmationTokenService confirmationTokenService;
	  	
		
	  	public AuthController(TokenService tokenService, AuthenticationManager authenticationManager,
				AuthService userService, ConfirmationTokenService confirmationTokenService) {
			super();
			this.tokenService = tokenService;
			this.authenticationManager = authenticationManager;
			this.userService = userService;
			this.confirmationTokenService = confirmationTokenService;
		}
	    
	  	@PostMapping("/register")
		ResponseEntity<RegisterResponse> signUp(@RequestBody @Valid NewUserForm newUser) {

			userService.signUpUser(newUser);
			RegisterResponse resp = new RegisterResponse("El usuario ha sido creado con exito!!!");

			return new ResponseEntity<RegisterResponse>(resp,HttpStatus.CREATED);
		}
		
	  	
	    @PostMapping("/login")
	    public ResponseEntity<LoginResponse> token(@RequestBody LoginForm loginForm) throws AuthenticationException {
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
	        LoginResponse response = new LoginResponse(loginForm.getUsername(),tokenService.generateToken(authentication));
	        return new ResponseEntity<LoginResponse>(response,HttpStatus.OK) ;
	    }
	    
		@GetMapping("/register/confirm")
		ResponseEntity<String> confirmMail(@RequestParam("token") String token) {

			Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

			optionalConfirmationToken.ifPresent(userService::confirmUser);

			return new ResponseEntity<>("Su cuenta ha sido activada!",HttpStatus.OK);
		}

}
