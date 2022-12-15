package com.portfolioap.apiportfolio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.Portfolio;

public interface PortfolioRepository extends CrudRepository<Portfolio,Integer>{

	Optional<Portfolio> findByNetworkUserUsername(String username);
}
