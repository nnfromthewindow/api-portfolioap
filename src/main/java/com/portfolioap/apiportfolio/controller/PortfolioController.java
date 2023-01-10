package com.portfolioap.apiportfolio.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.validation.Valid;

	@RestController
	@CrossOrigin
	@OpenAPIDefinition(info=@Info(title="Enpoints"))
	@SecurityScheme(
		    name = "bearerAuth",
		    type = SecuritySchemeType.HTTP,
		    bearerFormat = "JWT",
		    scheme = "bearer"
		)
	
	public class PortfolioController {

	@Autowired	
	private PortfolioService portfolioService;	

	@Autowired
	private UsersRepository usersRepository;

	@GetMapping(value="/*", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> getDefaultPortfolio() {
		List<Object> result = portfolioService.portfolio("nuccelli");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	/*
	@GetMapping(value="{username:(?!.*swagger-ui).+}/**", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> getSwagger() {
		
		List<Object> result = portfolioService.portfolio("nuccelli");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	*/
  	
	//@PreAuthorize("hasAuthority('SCOPE_USER')")
	@GetMapping(value="/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<Object>> getPortfolio(@PathVariable String username) {
		
		Optional<Users>user= usersRepository.findByUsername(username);
		if(!user.isPresent() && user.get().getUsername()!="login" && user.get().getUsername()!="register") {
	    	 HttpStatus status = HttpStatus.PERMANENT_REDIRECT;
		    	
	    	    URI location = URI.create("/nuccelli");
	    	    return ResponseEntity.status(status).location(location).build();
		}

		List<Object> result = portfolioService.portfolio(username);

	
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    
	}
		
	
	//METODOS POST PARA CADA ENDPOINT
	
	@PostMapping("/{username}/welcome")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<WelcomeDTO> createWelcome(@RequestBody @Valid WelcomeForm welcomeForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
	String user = SecurityContextHolder.getContext().getAuthentication().getName();
	String userForm = welcomeForm.getUserUsername();
	
	if(user.equals(userForm)) {
		Welcome welcome = portfolioService.createWelcome(welcomeForm);
		URI uri = uriComponentsBuilder.path("/welcome/{id}").buildAndExpand(welcome.getId()).toUri();
		return ResponseEntity.created(uri).body(new WelcomeDTO(welcome));
	}
	
	return new ResponseEntity<WelcomeDTO>(HttpStatus.BAD_REQUEST) ;
		
	}
	
	@PostMapping("/{username}/network")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<NetworkDTO> createNetwork(@RequestBody @Valid NetworkForm networkForm,
			UriComponentsBuilder uriComponentsBuilder) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userForm = networkForm.getUserUsername();
		
		if(user.equals(userForm)) {
			Network network = portfolioService.createNetwork(networkForm);
			URI uri = uriComponentsBuilder.path("/network/{id}").buildAndExpand(network.getId()).toUri();
			return ResponseEntity.created(uri).body(new NetworkDTO(network));
			};
			
			return new ResponseEntity<NetworkDTO>(HttpStatus.BAD_REQUEST) ;
	}

	@PostMapping("/{username}/avatar")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<AvatarImageDTO> createAvatarImage(@RequestBody @Valid AvatarImageForm avatarImageForm,
			UriComponentsBuilder uriComponentsBuilder) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userForm = avatarImageForm.getUserUsername();
		if(user.equals(userForm)) {
			AvatarImage avatarImage = portfolioService.createAvatarImage(avatarImageForm);
			URI uri = uriComponentsBuilder.path("/avatar/{id}").buildAndExpand(avatarImage.getId()).toUri();
			return ResponseEntity.created(uri).body(new AvatarImageDTO(avatarImage));
		};
		return new ResponseEntity<AvatarImageDTO>(HttpStatus.BAD_REQUEST) ;
	}
	
	@PostMapping("/{username}/banner")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<BannerImageDTO> createAvatarImage(@RequestBody @Valid BannerImageForm bannerImageForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userForm = bannerImageForm.getUserUsername();
		if(user.equals(userForm)) {
			BannerImage bannerImage = portfolioService.createBannerImage(bannerImageForm);
			URI uri = uriComponentsBuilder.path("/banner/{id}").buildAndExpand(bannerImage.getId()).toUri();
			return ResponseEntity.created(uri).body(new BannerImageDTO(bannerImage));
		};
		return new ResponseEntity<BannerImageDTO>(HttpStatus.BAD_REQUEST) ;
	}
	
	@PostMapping("/{username}/aboutme")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<AboutmeDTO> createAboutme(@RequestBody @Valid AboutmeForm aboutmeForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userForm = aboutmeForm.getUserUsername();
		if(user.equals(userForm)) {
			Aboutme aboutme = portfolioService.createAboutme(aboutmeForm);
			URI uri = uriComponentsBuilder.path("/aboutme/{id}").buildAndExpand(aboutme.getId()).toUri();
			return ResponseEntity.created(uri).body(new AboutmeDTO(aboutme));
		};
		return new ResponseEntity<AboutmeDTO>(HttpStatus.BAD_REQUEST) ;
		}
	
	@PostMapping("/{username}/education")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<EducationDTO> createEducation(@RequestBody @Valid EducationForm educationForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userForm = educationForm.getUserUsername();
		if(user.equals(userForm)) {
			Education education = portfolioService.createEducation(educationForm);
			URI uri = uriComponentsBuilder.path("/education/{id}").buildAndExpand(education.getId()).toUri();
			return ResponseEntity.created(uri).body(new EducationDTO(education));
		};
		return new ResponseEntity<EducationDTO>(HttpStatus.BAD_REQUEST) ;
		}
	
	@PostMapping("/{username}/experience")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<ExperienceDTO> createExperience(@RequestBody @Valid ExperienceForm experienceForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userForm = experienceForm.getUserUsername();
		if(user.equals(userForm)) {
			Experience experience = portfolioService.createExperience(experienceForm);
			URI uri = uriComponentsBuilder.path("/experience/{id}").buildAndExpand(experience.getId()).toUri();
			return ResponseEntity.created(uri).body(new ExperienceDTO(experience));
		};
		return new ResponseEntity<ExperienceDTO>(HttpStatus.BAD_REQUEST) ;
		}
	
	@PostMapping("/{username}/project")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<ProjectDTO> createProject(@RequestBody @Valid ProjectForm projectForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userForm = projectForm.getUserUsername();
		if(user.equals(userForm)) {
			Project project = portfolioService.createProject(projectForm);
			URI uri = uriComponentsBuilder.path("/project/{id}").buildAndExpand(project.getId()).toUri();
			return ResponseEntity.created(uri).body(new ProjectDTO(project));
		};
		return new ResponseEntity<ProjectDTO>(HttpStatus.BAD_REQUEST) ;
		}
	
	@PostMapping("/{username}/skill")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<SkillDTO> createSkill(@RequestBody @Valid SkillForm skillForm,
			UriComponentsBuilder uriComponentsBuilder) {
	
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userForm = skillForm.getUserUsername();
		if(user.equals(userForm)) {
			Skill skill = portfolioService.createSkill(skillForm);
			URI uri = uriComponentsBuilder.path("/skill/{id}").buildAndExpand(skill.getId()).toUri();
			return ResponseEntity.created(uri).body(new SkillDTO(skill));	
		};
		return new ResponseEntity<SkillDTO>(HttpStatus.BAD_REQUEST) ;
		}

//METODOS GET PARA EL DETALLE DE CADA ENDPOINT
	
	@GetMapping("/{username}/aboutme/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<AboutmeDTO> detailAboutme(@PathVariable UUID uuid) {
		AboutmeDTO detail = portfolioService.detailAboutme(uuid);
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/avatar/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<AvatarImageDTO> detailAvatarImage(@PathVariable UUID uuid) {
		AvatarImageDTO detail = portfolioService.detailAvatarImage(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/banner/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<BannerImageDTO> detailBannerImage(@PathVariable UUID uuid) {
		BannerImageDTO detail = portfolioService.detailBannerImage(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/education/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<EducationDTO> detailEducation(@PathVariable UUID uuid) {
		EducationDTO detail = portfolioService.detailEducation(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/experience/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<ExperienceDTO> detailExperience(@PathVariable UUID uuid) {
		ExperienceDTO detail = portfolioService.detailExperience(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/network/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<NetworkDTO> detailNetwork(@PathVariable UUID uuid) {
		NetworkDTO detail = portfolioService.detailNetwork(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/project/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<ProjectDTO> detailProject(@PathVariable UUID uuid) {
		ProjectDTO detail = portfolioService.detailProject(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/skill/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<SkillDTO> detailSkill(@PathVariable UUID uuid) {
		SkillDTO detail = portfolioService.detailSkill(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
	@GetMapping("/{username}/welcome/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<WelcomeDTO> detailWelcome(@PathVariable UUID uuid) {
		WelcomeDTO detail = portfolioService.detailWelcome(uuid);
		
		return ResponseEntity.ok(detail);
	}
	
//METODOS PUT PARA CADA ENDPOINT
	
	@PutMapping("/{username}/aboutme/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<AboutmeDTO> updateAboutme(@PathVariable UUID uuid, @RequestBody @Validated UpdateAboutmeForm updateAboutmeForm, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		
		if(user.equals(userParam)) {
			Aboutme aboutme = portfolioService.updateAboutme(uuid, updateAboutmeForm);
			
			return ResponseEntity.ok(new AboutmeDTO(aboutme));
		}else return new ResponseEntity<AboutmeDTO>(HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/{username}/avatar/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<AvatarImageDTO> updateAvatarImage(@PathVariable UUID uuid, @RequestBody @Validated UpdateAvatarImageForm updateAvatarImageForm, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			AvatarImage avatar = portfolioService.updateAvatarImage(uuid, updateAvatarImageForm);
			return ResponseEntity.ok(new AvatarImageDTO(avatar));
			
		}else return new ResponseEntity<AvatarImageDTO>(HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/{username}/banner/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<BannerImageDTO> updateBannerImage(@PathVariable UUID uuid, @RequestBody @Validated UpdateBannerImageForm updateBannerImageForm, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			BannerImage banner = portfolioService.updateBannerImage(uuid, updateBannerImageForm);
			
			return ResponseEntity.ok(new BannerImageDTO(banner));
		}else return new ResponseEntity<BannerImageDTO>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{username}/education/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<EducationDTO> updateEducation(@PathVariable UUID uuid, @RequestBody @Validated UpdateEducationForm updateEducationForm, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			Education education = portfolioService.updateEducation(uuid, updateEducationForm);
			
			return ResponseEntity.ok(new EducationDTO(education));
		}else return new ResponseEntity<EducationDTO>(HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/{username}/experience/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<ExperienceDTO> updateExperience(@PathVariable UUID uuid, @RequestBody @Validated UpdateExperienceForm updateExperienceForm, @PathVariable String username) {
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			Experience experience = portfolioService.updateExperience(uuid, updateExperienceForm);
			
			return ResponseEntity.ok(new ExperienceDTO(experience));
		}else return new ResponseEntity<ExperienceDTO>(HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/{username}/network/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<NetworkDTO> updateNetwork(@PathVariable UUID uuid, @RequestBody @Validated UpdateNetworkForm updateNetworkForm, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			Network network = portfolioService.updateNetwork(uuid, updateNetworkForm);
			
			return ResponseEntity.ok(new NetworkDTO(network));
		}else return new ResponseEntity<NetworkDTO>(HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/{username}/project/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<ProjectDTO> updateProject(@PathVariable UUID uuid, @RequestBody @Validated UpdateProjectForm updateProjectForm, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			Project project = portfolioService.updateProject(uuid, updateProjectForm);
			
			return ResponseEntity.ok(new ProjectDTO(project));
		}else return new ResponseEntity<ProjectDTO>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{username}/skill/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<SkillDTO> updateSkill(@PathVariable UUID uuid, @RequestBody @Validated UpdateSkillForm updateSkillForm, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			Skill skill = portfolioService.updateSkill(uuid, updateSkillForm);
			
			return ResponseEntity.ok(new SkillDTO(skill));
		}else return new ResponseEntity<SkillDTO>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{username}/welcome/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<WelcomeDTO> updateWelcome(@PathVariable UUID uuid, @RequestBody @Validated UpdateWelcomeForm updateWelcomeForm, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			Welcome welcome = portfolioService.updateWelcome(uuid, updateWelcomeForm);
			
			return ResponseEntity.ok(new WelcomeDTO(welcome));
		}else return new ResponseEntity<WelcomeDTO>(HttpStatus.BAD_REQUEST);
		
	}
	
	
//METODOS DELETE PARA CADA ENDPOINT	
	
	@DeleteMapping("/{username}/aboutme/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity deleteAboutme(@PathVariable UUID uuid, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			portfolioService.deleteAboutme(uuid);
			
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{username}/avatar/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity deleteAvatarImage(@PathVariable UUID uuid, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			portfolioService.deleteAvatarImage(uuid);
			
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{username}/banner/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity deleteBannerImage(@PathVariable UUID uuid, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			portfolioService.deleteBannerImage(uuid);
			
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{username}/education/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity deleteEducation(@PathVariable UUID uuid, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			portfolioService.deleteEducation(uuid);
			
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{username}/experience/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity deleteExperience(@PathVariable UUID uuid, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			portfolioService.deleteExperience(uuid);
			
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{username}/network/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity deleteNetwork(@PathVariable UUID uuid, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			portfolioService.deleteNetwork(uuid);
			
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{username}/project/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity deleteProject(@PathVariable UUID uuid, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			portfolioService.deleteProject(uuid);
			
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{username}/skill/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity deleteSkill(@PathVariable UUID uuid, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			portfolioService.deleteSkill(uuid);
			
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{username}/welcome/{uuid}")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity deleteWelcome(@PathVariable UUID uuid, @PathVariable String username) {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		String userParam = username;

		if(user.equals(userParam)) {
			portfolioService.deleteWelcome(uuid);
			
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
	}
	
}
