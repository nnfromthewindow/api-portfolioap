package com.portfolioap.apiportfolio.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.AvatarImage;

public interface AvatarImageRepository extends CrudRepository<AvatarImage,UUID>{
	Optional<List<AvatarImage>> findByUserUsername(String username);
}
