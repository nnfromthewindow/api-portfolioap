package com.portfolioap.apiportfolio.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.portfolioap.apiportfolio.controller.DTO.AboutmeDTO;
import com.portfolioap.apiportfolio.controller.DTO.AvatarImageDTO;
import com.portfolioap.apiportfolio.controller.DTO.BannerImageDTO;
import com.portfolioap.apiportfolio.controller.DTO.EducationDTO;
import com.portfolioap.apiportfolio.controller.DTO.ExperienceDTO;
import com.portfolioap.apiportfolio.controller.DTO.NetworkDTO;
import com.portfolioap.apiportfolio.controller.DTO.ProjectDTO;
import com.portfolioap.apiportfolio.controller.DTO.SkillDTO;
import com.portfolioap.apiportfolio.controller.DTO.WelcomeDTO;
import com.portfolioap.apiportfolio.controller.form.AboutmeForm;
import com.portfolioap.apiportfolio.controller.form.AvatarImageForm;
import com.portfolioap.apiportfolio.controller.form.BannerImageForm;
import com.portfolioap.apiportfolio.controller.form.EducationForm;
import com.portfolioap.apiportfolio.controller.form.ExperienceForm;
import com.portfolioap.apiportfolio.controller.form.NetworkForm;
import com.portfolioap.apiportfolio.controller.form.NewUserForm;
import com.portfolioap.apiportfolio.controller.form.ProjectForm;
import com.portfolioap.apiportfolio.controller.form.SkillForm;
import com.portfolioap.apiportfolio.controller.form.UpdateAboutmeForm;
import com.portfolioap.apiportfolio.controller.form.UpdateAvatarImageForm;
import com.portfolioap.apiportfolio.controller.form.UpdateBannerImageForm;
import com.portfolioap.apiportfolio.controller.form.UpdateEducationForm;
import com.portfolioap.apiportfolio.controller.form.UpdateExperienceForm;
import com.portfolioap.apiportfolio.controller.form.UpdateNetworkForm;
import com.portfolioap.apiportfolio.controller.form.UpdateProjectForm;
import com.portfolioap.apiportfolio.controller.form.UpdateSkillForm;
import com.portfolioap.apiportfolio.controller.form.UpdateWelcomeForm;
import com.portfolioap.apiportfolio.controller.form.WelcomeForm;
import com.portfolioap.apiportfolio.model.Aboutme;
import com.portfolioap.apiportfolio.model.AvatarImage;
import com.portfolioap.apiportfolio.model.BannerImage;
import com.portfolioap.apiportfolio.model.Education;
import com.portfolioap.apiportfolio.model.Experience;
import com.portfolioap.apiportfolio.model.Network;
import com.portfolioap.apiportfolio.model.Project;
import com.portfolioap.apiportfolio.model.Skill;
import com.portfolioap.apiportfolio.model.Users;
import com.portfolioap.apiportfolio.model.Welcome;
import com.portfolioap.apiportfolio.repository.UsersRepository;
import com.portfolioap.apiportfolio.service.PortfolioService;

import jakarta.validation.Valid;

	@Controller
	@RequestMapping("/")
	public class PortfolioController {

	@Autowired	
	private PortfolioService portfolioService;	
	
	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping("/{username}")
	public ResponseEntity<List<Object>> getPortfolio(@PathVariable String username) {
		
		Optional<Users>user= usersRepository.findByUsername(username);
		if(!user.isPresent()) {
	    	 HttpStatus status = HttpStatus.PERMANENT_REDIRECT;
		    	
	    	    URI location = URI.create("/nuccelli");
	    	    return ResponseEntity.status(status).location(location).build();
		}
		List<Object> result = portfolioService.portfolio(username);

	
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    
	}
	/*
	@PostMapping("/register")
	public String processRegister(NewUserForm newUserForm) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(newUserForm.getPassword());
		newUserForm.setPassword(encodedPassword);
		
		usersRepository.save(newUserForm);
		
		return "redirect:/"+newUserForm.getUsername();
	}
*/
	//METODOS POST PARA CADA ENDPOINT
	
	@PostMapping("/{username}/welcome")
	public ResponseEntity<WelcomeDTO> createWelcome(@RequestBody @Valid WelcomeForm welcomeForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
	Welcome welcome = portfolioService.createWelcome(welcomeForm);
	
	URI uri = uriComponentsBuilder.path("/welcome/{id}").buildAndExpand(welcome.getId()).toUri();
	
	return ResponseEntity.created(uri).body(new WelcomeDTO(welcome));
	}
	
	@PostMapping("/{username}/network")
	public ResponseEntity<NetworkDTO> createNetwork(@RequestBody @Valid NetworkForm networkForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
	Network network = portfolioService.createNetwork(networkForm);
	
	URI uri = uriComponentsBuilder.path("/network/{id}").buildAndExpand(network.getId()).toUri();
	
	return ResponseEntity.created(uri).body(new NetworkDTO(network));
	}

	@PostMapping("/{username}/avatar")
	public ResponseEntity<AvatarImageDTO> createAvatarImage(@RequestBody @Valid AvatarImageForm avatarImageForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
	AvatarImage avatarImage = portfolioService.createAvatarImage(avatarImageForm);
	
	URI uri = uriComponentsBuilder.path("/avatar/{id}").buildAndExpand(avatarImage.getId()).toUri();
	
	return ResponseEntity.created(uri).body(new AvatarImageDTO(avatarImage));
	}
	
	@PostMapping("/{username}/banner")
	public ResponseEntity<BannerImageDTO> createAvatarImage(@RequestBody @Valid BannerImageForm bannerImageForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		BannerImage bannerImage = portfolioService.createBannerImage(bannerImageForm);
	
	URI uri = uriComponentsBuilder.path("/banner/{id}").buildAndExpand(bannerImage.getId()).toUri();
	
	return ResponseEntity.created(uri).body(new BannerImageDTO(bannerImage));
	}
	
	@PostMapping("/{username}/aboutme")
	public ResponseEntity<AboutmeDTO> createAboutme(@RequestBody @Valid AboutmeForm aboutmeForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		Aboutme aboutme = portfolioService.createAboutme(aboutmeForm);
	
	URI uri = uriComponentsBuilder.path("/aboutme/{id}").buildAndExpand(aboutme.getId()).toUri();
	
	return ResponseEntity.created(uri).body(new AboutmeDTO(aboutme));
	}
	
	@PostMapping("/{username}/education")
	public ResponseEntity<EducationDTO> createEducation(@RequestBody @Valid EducationForm educationForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		Education education = portfolioService.createEducation(educationForm);
	
	URI uri = uriComponentsBuilder.path("/education/{id}").buildAndExpand(education.getId()).toUri();
	
	return ResponseEntity.created(uri).body(new EducationDTO(education));
	}
	
	@PostMapping("/{username}/experience")
	public ResponseEntity<ExperienceDTO> createExperience(@RequestBody @Valid ExperienceForm experienceForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		Experience experience = portfolioService.createExperience(experienceForm);
	
	URI uri = uriComponentsBuilder.path("/experience/{id}").buildAndExpand(experience.getId()).toUri();
	
	return ResponseEntity.created(uri).body(new ExperienceDTO(experience));
	}
	
	@PostMapping("/{username}/project")
	public ResponseEntity<ProjectDTO> createProject(@RequestBody @Valid ProjectForm projectForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		Project project = portfolioService.createProject(projectForm);
	
	URI uri = uriComponentsBuilder.path("/project/{id}").buildAndExpand(project.getId()).toUri();
	
	return ResponseEntity.created(uri).body(new ProjectDTO(project));
	}
	
	@PostMapping("/{username}/skill")
	public ResponseEntity<SkillDTO> createSkill(@RequestBody @Valid SkillForm skillForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		Skill skill = portfolioService.createSkill(skillForm);
	
	URI uri = uriComponentsBuilder.path("/skill/{id}").buildAndExpand(skill.getId()).toUri();
	
	return ResponseEntity.created(uri).body(new SkillDTO(skill));
	}

//METODOS GET PARA EL DETALLE DE CADA ENDPOINT
	
	@GetMapping("/{username}/aboutme/{uuid}")
	public ResponseEntity<AboutmeDTO> detailAboutme(@PathVariable UUID uuid) {
		AboutmeDTO detail = portfolioService.detailAboutme(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/avatar/{uuid}")
	public ResponseEntity<AvatarImageDTO> detailAvatarImage(@PathVariable UUID uuid) {
		AvatarImageDTO detail = portfolioService.detailAvatarImage(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/banner/{uuid}")
	public ResponseEntity<BannerImageDTO> detailBannerImage(@PathVariable UUID uuid) {
		BannerImageDTO detail = portfolioService.detailBannerImage(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/education/{uuid}")
	public ResponseEntity<EducationDTO> detailEducation(@PathVariable UUID uuid) {
		EducationDTO detail = portfolioService.detailEducation(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/experience/{uuid}")
	public ResponseEntity<ExperienceDTO> detailExperience(@PathVariable UUID uuid) {
		ExperienceDTO detail = portfolioService.detailExperience(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/network/{uuid}")
	public ResponseEntity<NetworkDTO> detailNetwork(@PathVariable UUID uuid) {
		NetworkDTO detail = portfolioService.detailNetwork(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/project/{uuid}")
	public ResponseEntity<ProjectDTO> detailProject(@PathVariable UUID uuid) {
		ProjectDTO detail = portfolioService.detailProject(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/skill/{uuid}")
	public ResponseEntity<SkillDTO> detailSkill(@PathVariable UUID uuid) {
		SkillDTO detail = portfolioService.detailSkill(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/welcome/{uuid}")
	public ResponseEntity<WelcomeDTO> detailWelcome(@PathVariable UUID uuid) {
		WelcomeDTO detail = portfolioService.detailWelcome(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
//METODOS PUT PARA CADA ENDPOINT
	
	@PutMapping("/{username}/aboutme/{uuid}")
	public ResponseEntity<AboutmeDTO> updateAboutme(@PathVariable UUID uuid, @RequestBody @Validated UpdateAboutmeForm updateAboutmeForm) {
		Aboutme aboutme = portfolioService.updateAboutme(uuid, updateAboutmeForm);
		
		return ResponseEntity.ok(new AboutmeDTO(aboutme));
	}
	
	@PutMapping("/{username}/avatar/{uuid}")
	public ResponseEntity<AvatarImageDTO> updateAvatarImage(@PathVariable UUID uuid, @RequestBody @Validated UpdateAvatarImageForm updateAvatarImageForm) {
		AvatarImage avatar = portfolioService.updateAvatarImage(uuid, updateAvatarImageForm);
		
		return ResponseEntity.ok(new AvatarImageDTO(avatar));
	}
	
	@PutMapping("/{username}/banner/{uuid}")
	public ResponseEntity<BannerImageDTO> updateBannerImage(@PathVariable UUID uuid, @RequestBody @Validated UpdateBannerImageForm updateBannerImageForm) {
		BannerImage banner = portfolioService.updateBannerImage(uuid, updateBannerImageForm);
		
		return ResponseEntity.ok(new BannerImageDTO(banner));
	}
	
	@PutMapping("/{username}/education/{uuid}")
	public ResponseEntity<EducationDTO> updateEducation(@PathVariable UUID uuid, @RequestBody @Validated UpdateEducationForm updateEducationForm) {
		Education education = portfolioService.updateEducation(uuid, updateEducationForm);
		
		return ResponseEntity.ok(new EducationDTO(education));
	}
	
	@PutMapping("/{username}/experience/{uuid}")
	public ResponseEntity<ExperienceDTO> updateExperience(@PathVariable UUID uuid, @RequestBody @Validated UpdateExperienceForm updateExperienceForm) {
		Experience experience = portfolioService.updateExperience(uuid, updateExperienceForm);
		
		return ResponseEntity.ok(new ExperienceDTO(experience));
	}
	
	@PutMapping("/{username}/network/{uuid}")
	public ResponseEntity<NetworkDTO> updateNetwork(@PathVariable UUID uuid, @RequestBody @Validated UpdateNetworkForm updateNetworkForm) {
		Network network = portfolioService.updateNetwork(uuid, updateNetworkForm);
		
		return ResponseEntity.ok(new NetworkDTO(network));
	}
	
	@PutMapping("/{username}/project/{uuid}")
	public ResponseEntity<ProjectDTO> updateProject(@PathVariable UUID uuid, @RequestBody @Validated UpdateProjectForm updateProjectForm) {
		Project project = portfolioService.updateProject(uuid, updateProjectForm);
		
		return ResponseEntity.ok(new ProjectDTO(project));
	}
	
	@PutMapping("/{username}/skill/{uuid}")
	public ResponseEntity<SkillDTO> updateSkill(@PathVariable UUID uuid, @RequestBody @Validated UpdateSkillForm updateSkillForm) {
		Skill skill = portfolioService.updateSkill(uuid, updateSkillForm);
		
		return ResponseEntity.ok(new SkillDTO(skill));
	}
	
	@PutMapping("/{username}/welcome/{uuid}")
	public ResponseEntity<WelcomeDTO> updateWelcome(@PathVariable UUID uuid, @RequestBody @Validated UpdateWelcomeForm updateWelcomeForm) {
		Welcome welcome = portfolioService.updateWelcome(uuid, updateWelcomeForm);
		
		return ResponseEntity.ok(new WelcomeDTO(welcome));
	}
	
	
//METODOS DELETE PARA CADA ENDPOINT	
	
	@DeleteMapping("/{username}/aboutme/{uuid}")
	public ResponseEntity deleteAboutme(@PathVariable UUID uuid) {
		portfolioService.deleteAboutme(uuid);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{username}/avatar/{uuid}")
	public ResponseEntity deleteAvatarImage(@PathVariable UUID uuid) {
		portfolioService.deleteAvatarImage(uuid);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{username}/banner/{uuid}")
	public ResponseEntity deleteBannerImage(@PathVariable UUID uuid) {
		portfolioService.deleteBannerImage(uuid);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{username}/education/{uuid}")
	public ResponseEntity deleteEducation(@PathVariable UUID uuid) {
		portfolioService.deleteEducation(uuid);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{username}/experience/{uuid}")
	public ResponseEntity deleteExperience(@PathVariable UUID uuid) {
		portfolioService.deleteExperience(uuid);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{username}/network/{uuid}")
	public ResponseEntity deleteNetwork(@PathVariable UUID uuid) {
		portfolioService.deleteNetwork(uuid);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{username}/project/{uuid}")
	public ResponseEntity deleteProject(@PathVariable UUID uuid) {
		portfolioService.deleteProject(uuid);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{username}/skill/{uuid}")
	public ResponseEntity deleteSkill(@PathVariable UUID uuid) {
		portfolioService.deleteSkill(uuid);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{username}/welcome/{uuid}")
	public ResponseEntity deleteWelcome(@PathVariable UUID uuid) {
		portfolioService.deleteWelcome(uuid);
		
		return ResponseEntity.ok().build();
	}
	
	
}
