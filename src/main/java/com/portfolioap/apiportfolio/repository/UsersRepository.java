package com.portfolioap.apiportfolio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
	Optional<Users> findByUsername(String username);
}
	