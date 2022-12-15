package com.portfolioap.apiportfolio.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.Skill;

public interface SkillRepository extends CrudRepository<Skill,UUID> {
	Optional<List<Skill>> findByUserUsername(String username);

}
