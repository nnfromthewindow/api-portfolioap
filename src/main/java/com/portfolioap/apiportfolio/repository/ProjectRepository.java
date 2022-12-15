package com.portfolioap.apiportfolio.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.Project;

public interface ProjectRepository extends CrudRepository<Project,UUID>{
	Optional<List<Project>> findByUserUsername(String username);

}
