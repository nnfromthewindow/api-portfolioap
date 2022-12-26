package com.portfolioap.apiportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Portfolio API"))
public class ApiPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPortfolioApplication.class, args);
	}
	
}
