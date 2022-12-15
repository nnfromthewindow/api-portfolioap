package com.portfolioap.apiportfolio.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.Education;

public interface EducationRepository extends CrudRepository<Education,UUID> {
	Optional<List<Education>> findByUserUsername(String username);

}
