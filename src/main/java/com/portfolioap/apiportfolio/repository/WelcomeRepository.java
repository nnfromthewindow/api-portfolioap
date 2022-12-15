package com.portfolioap.apiportfolio.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.Welcome;

public interface WelcomeRepository extends CrudRepository<Welcome,UUID>{
	Optional<List<Welcome>> findByUserUsername(String username);

}
