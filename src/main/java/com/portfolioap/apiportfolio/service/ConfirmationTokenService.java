package com.portfolioap.apiportfolio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioap.apiportfolio.model.ConfirmationToken;
import com.portfolioap.apiportfolio.repository.ConfirmationTokenRepository;

@Service
public class ConfirmationTokenService {

	@Autowired
	private  ConfirmationTokenRepository confirmationTokenRepository;

	public void saveConfirmationToken(ConfirmationToken confirmationToken) {

		confirmationTokenRepository.save(confirmationToken);
	}

	public void deleteConfirmationToken(Long id){

		confirmationTokenRepository.deleteById(id);
	}

	public Optional<ConfirmationToken> findConfirmationTokenByToken(String token) {

		return confirmationTokenRepository.findConfirmationTokenByConfirmationToken(token);
	}
}


