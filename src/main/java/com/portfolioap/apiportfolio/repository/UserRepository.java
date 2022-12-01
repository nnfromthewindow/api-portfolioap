package com.portfolioap.apiportfolio.repository;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
	