package com.portfolioap.apiportfolio.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.Network;

public interface NetworkRepository extends CrudRepository<Network, UUID>{
	Optional<List<Network>> findByUserUsername(String username);
}
