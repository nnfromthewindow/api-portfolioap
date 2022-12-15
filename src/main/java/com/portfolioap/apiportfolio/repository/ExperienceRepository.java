package com.portfolioap.apiportfolio.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.Experience;

public interface ExperienceRepository extends CrudRepository<Experience,UUID>{
	Optional<List<Experience>> findByUserUsername(String username);
}
