package com.portfolioap.apiportfolio.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.Aboutme;

public interface AboutmeRepository extends CrudRepository<Aboutme, UUID>{
	Optional<List<Aboutme>> findByUserUsername(String username);
}
