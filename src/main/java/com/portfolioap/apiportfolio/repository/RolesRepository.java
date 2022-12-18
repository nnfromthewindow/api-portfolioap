package com.portfolioap.apiportfolio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.Roles;

public interface RolesRepository extends CrudRepository<Roles, Integer>{
	Optional<Roles> findByRole(String name);
}
