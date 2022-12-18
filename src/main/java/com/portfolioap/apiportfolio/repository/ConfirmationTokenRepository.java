package com.portfolioap.apiportfolio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken,Long> {
	
	Optional<ConfirmationToken> findConfirmationTokenByConfirmationToken(String token);

}
