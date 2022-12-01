package com.portfolioap.apiportfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portfolioap.apiportfolio.model.User;
import com.portfolioap.apiportfolio.repository.UserRepository;

@Controller
@RequestMapping("/{username}")
public class PortfolioController {

@Autowired	
private UserRepository userRepository;		


@GetMapping(path="/all")
public @ResponseBody Iterable<User> getAllUsers() {
  // This returns a JSON or XML with the users
  return userRepository.findAll();
}



}
