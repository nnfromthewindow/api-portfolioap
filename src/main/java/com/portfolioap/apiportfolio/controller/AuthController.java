package com.portfolioap.apiportfolio.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolioap.apiportfolio.config.security.AuthService;
import com.portfolioap.apiportfolio.config.security.TokenService;
import com.portfolioap.apiportfolio.controller.form.LoginForm;
import com.portfolioap.apiportfolio.controller.form.NewUserForm;
import com.portfolioap.apiportfolio.model.ConfirmationToken;
import com.portfolioap.apiportfolio.model.Users;
import com.portfolioap.apiportfolio.service.ConfirmationTokenService;

@Controller
public class AuthController {

	  	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

	  	@Autowired
	    private  TokenService tokenService;
	  	@Autowired
	    private  AuthenticationManager authenticationManager;
	  	@Autowired
	    private  AuthService userService;
	  	@Autowired
	    private ConfirmationTokenService confirmationTokenService;
	    
	    
	    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
	        this.tokenService = tokenService;
	        this.authenticationManager = authenticationManager;
	    }

	    @PostMapping("/login")
	    public String token(@RequestBody LoginForm loginForm) throws AuthenticationException {
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
	        return tokenService.generateToken(authentication);
	    }

	    @GetMapping("/sign-in")
		String signIn() {

			return "sign-in";
		}

		@GetMapping("/sign-up")
		String signUpPage(NewUserForm newUser, Model model) {
			
			model.addAttribute("username", newUser.getUsername() );
			model.addAttribute("password", newUser.getPassword() );
			model.addAttribute("email", newUser.getEmail() );
			
			return "sign-up";
		}

		@PostMapping("/sign-up")
		String signUp(NewUserForm newUser) {

			userService.signUpUser(newUser);

			return "redirect:/sign-in";
		}

		@GetMapping("/sign-up/confirm")
		String confirmMail(@RequestParam("token") String token) {

			Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

			optionalConfirmationToken.ifPresent(userService::confirmUser);

			return "redirect:/sign-in";
		}

    
}
