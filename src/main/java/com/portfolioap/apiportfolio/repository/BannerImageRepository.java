package com.portfolioap.apiportfolio.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.portfolioap.apiportfolio.model.BannerImage;

public interface BannerImageRepository extends CrudRepository<BannerImage, UUID>{
	Optional<List<BannerImage>> findByUserUsername(String username);
}
