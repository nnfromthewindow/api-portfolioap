package com.portfolioap.apiportfolio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.portfolioap.apiportfolio.exception.NotFoundException;
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
import com.portfolioap.apiportfolio.repository.AboutmeRepository;
import com.portfolioap.apiportfolio.repository.AvatarImageRepository;
import com.portfolioap.apiportfolio.repository.BannerImageRepository;
import com.portfolioap.apiportfolio.repository.EducationRepository;
import com.portfolioap.apiportfolio.repository.ExperienceRepository;
import com.portfolioap.apiportfolio.repository.NetworkRepository;
import com.portfolioap.apiportfolio.repository.ProjectRepository;
import com.portfolioap.apiportfolio.repository.SkillRepository;
import com.portfolioap.apiportfolio.repository.UsersRepository;
import com.portfolioap.apiportfolio.repository.WelcomeRepository;

import jakarta.transaction.Transactional;

@Service
public class PortfolioService {

	@Autowired
	private NetworkRepository networkRepository;
	
	@Autowired
	private BannerImageRepository bannerImageRepository;
	
	@Autowired
	private AboutmeRepository aboutmeRepository;
	
	@Autowired
	private AvatarImageRepository avatarImageRepository;
	
	@Autowired
	private EducationRepository educationRepository;
	
	@Autowired
	private ExperienceRepository experienceRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private WelcomeRepository welcomeRepository;
	
	@Autowired
	private UsersRepository usersRepository;

	
	public List<Object> portfolio(String username){

		//USAMOS MODEL MAPPER PARA MAPEAR ENTIDADES A DTOs
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration()
		  .setFieldMatchingEnabled(true)
		  .setFieldAccessLevel(AccessLevel.PRIVATE);
		
		//json para traer todo el porfolio
		List<Object>jsonportfolio= new ArrayList<>();
		
		//traemos repositorios
		Optional<List<Network>>networks = networkRepository.findByUserUsername(username);
		Optional<List<BannerImage>>bannerImage = bannerImageRepository.findByUserUsername(username);
		Optional<List<Aboutme>>aboutme = aboutmeRepository.findByUserUsername(username);
		Optional<List<AvatarImage>>avatarImage = avatarImageRepository.findByUserUsername(username);
		Optional<List<Education>>education = educationRepository.findByUserUsername(username);
		Optional<List<Experience>>experience = experienceRepository.findByUserUsername(username);
		Optional<List<Project>>project = projectRepository.findByUserUsername(username);
		Optional<List<Skill>>skill = skillRepository.findByUserUsername(username);
		Optional<List<Welcome>>welcome = welcomeRepository.findByUserUsername(username);
		
		
		List<NetworkDTO>networkDTO = networks.get().stream()
				  .map(net -> mapper.map(net, NetworkDTO.class))
				  .collect(Collectors.toList());
		List<BannerImageDTO>bannerDTO = bannerImage.get().stream()
				  .map(bann -> mapper.map(bann, BannerImageDTO.class))
				  .collect(Collectors.toList());
		List<AboutmeDTO>aboutmeDTO = aboutme.get().stream()
				  .map(about -> mapper.map(about, AboutmeDTO.class))
				  .collect(Collectors.toList());
		List<AvatarImageDTO>avatarImageDTO = avatarImage.get().stream()
				  .map(avat -> mapper.map(avat, AvatarImageDTO.class))
				  .collect(Collectors.toList());
		List<EducationDTO>educationDTO = education.get().stream()
				  .map(avat -> mapper.map(avat, EducationDTO.class))
				  .collect(Collectors.toList());
		List<ExperienceDTO>experienceDTO = experience.get().stream()
				  .map(exp -> mapper.map(exp, ExperienceDTO.class))
				  .collect(Collectors.toList());
		List<ProjectDTO>projectDTO = project.get().stream()
				  .map(proj -> mapper.map(proj, ProjectDTO.class))
				  .collect(Collectors.toList());
		List<SkillDTO>skillDTO = skill.get().stream()
				  .map(skl -> mapper.map(skl, SkillDTO.class))
				  .collect(Collectors.toList());
		List<WelcomeDTO>welcomeDTO = welcome.get().stream()
				  .map(wel -> mapper.map(wel, WelcomeDTO.class))
				  .collect(Collectors.toList());
		
		
		Map<String, Object> welcomeMap = new HashMap<>();
		welcomeMap.put("welcome", welcomeDTO);
		Map<String, Object> networkMap = new HashMap<>();
		networkMap.put("network", networkDTO);
		Map<String, Object> avatarMap = new HashMap<>();
		avatarMap.put("avatarImage", avatarImageDTO);
		Map<String, Object> bannerMap = new HashMap<>();
		bannerMap.put("bannerImage", bannerDTO);
		Map<String, Object> aboutMap = new HashMap<>();
		aboutMap.put("aboutme", aboutmeDTO);
		Map<String, Object> educationMap = new HashMap<>();
		educationMap.put("education", educationDTO);
		Map<String, Object> experienceMap = new HashMap<>();
		experienceMap.put("experience", experienceDTO);
		Map<String, Object> skillMap = new HashMap<>();
		skillMap.put("skills", skillDTO);
		Map<String, Object> projectMap = new HashMap<>();
		projectMap.put("projects", projectDTO);
		
		jsonportfolio.add(networkMap);
		jsonportfolio.add(welcomeMap);
		jsonportfolio.add(avatarMap);
		jsonportfolio.add(bannerMap);
		jsonportfolio.add(aboutMap);
		jsonportfolio.add(educationMap);
		jsonportfolio.add(experienceMap);
		jsonportfolio.add(skillMap);
		jsonportfolio.add(projectMap);
				
		return jsonportfolio;
		
	};
	
//CREACION METODOS POST PARA CADA ENDPOINT
	
	public Welcome createWelcome(WelcomeForm welcomeForm) {
		
		Optional<Users>user = usersRepository.findByUsername(welcomeForm.getUserUsername());
		
		Welcome welcome = welcomeForm.convert(user);
		
		return welcomeRepository.save(welcome);
		
	}
	
	public Network createNetwork(NetworkForm networkForm) {
		
		Optional<Users>user = usersRepository.findByUsername(networkForm.getUserUsername());
		
		Network network = networkForm.convert(user);
		
		return networkRepository.save(network);
		
	}
	
	public AvatarImage createAvatarImage(AvatarImageForm avatarImageForm) {
		
		Optional<Users>user = usersRepository.findByUsername(avatarImageForm.getUserUsername());
		
		AvatarImage avatarImage = avatarImageForm.convert(user);
		
		return avatarImageRepository.save(avatarImage);
		
	}

	public BannerImage createBannerImage(BannerImageForm bannerImageForm) {
		
		Optional<Users>user = usersRepository.findByUsername(bannerImageForm.getUserUsername());
		
		BannerImage bannerImage = bannerImageForm.convert(user);
		
		return bannerImageRepository.save(bannerImage);
		
	}
	
	public Aboutme createAboutme(AboutmeForm aboutmeForm) {
		
		Optional<Users>user = usersRepository.findByUsername(aboutmeForm.getUserUsername());
		
		Aboutme aboutme = aboutmeForm.convert(user);
		
		return aboutmeRepository.save(aboutme);
		
	}
	
	public Education createEducation(EducationForm educationForm) {
		
		Optional<Users>user = usersRepository.findByUsername(educationForm.getUserUsername());
		
		Education education = educationForm.convert(user);
		
		return educationRepository.save(education);
		
	}
	
	public Experience createExperience(ExperienceForm experienceForm) {
		
		Optional<Users>user = usersRepository.findByUsername(experienceForm.getUserUsername());
		
		Experience experience = experienceForm.convert(user);
		
		return experienceRepository.save(experience);
		
	}
	
public Project createProject(ProjectForm projectForm) {
		
		Optional<Users>user = usersRepository.findByUsername(projectForm.getUserUsername());
		
		Project project = projectForm.convert(user);
		
		return projectRepository.save(project);
		
	}
	
public Skill createSkill(SkillForm skillForm) {
	
	Optional<Users>user = usersRepository.findByUsername(skillForm.getUserUsername());
	
	Skill skill = skillForm.convert(user);
	
	return skillRepository.save(skill);
	
}

//METODOS GET PARA EL DETALLE DE CADA ENDPOINT

public AboutmeDTO detailAboutme(UUID uuid) {
	Optional<Aboutme> aboutme = aboutmeRepository.findById(uuid);
	
	if(!aboutme.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	return new AboutmeDTO(aboutme.get());
}

public AvatarImageDTO detailAvatarImage(UUID uuid) {
	Optional<AvatarImage> avatarImage = avatarImageRepository.findById(uuid);
	
	if(!avatarImage.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	return new AvatarImageDTO(avatarImage.get());
}

public BannerImageDTO detailBannerImage(UUID uuid) {
	Optional<BannerImage> bannerImage = bannerImageRepository.findById(uuid);
	
	if(!bannerImage.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	return new BannerImageDTO(bannerImage.get());
}

public EducationDTO detailEducation(UUID uuid) {
	Optional<Education> education = educationRepository.findById(uuid);
	
	if(!education.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	return new EducationDTO(education.get());
}

public ExperienceDTO detailExperience(UUID uuid) {
	Optional<Experience> experience = experienceRepository.findById(uuid);
	
	if(!experience.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	return new ExperienceDTO(experience.get());
}

public NetworkDTO detailNetwork(UUID uuid) {
	Optional<Network> network = networkRepository.findById(uuid);
	
	if(!network.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	return new NetworkDTO(network.get());
}

public ProjectDTO detailProject(UUID uuid) {
	Optional<Project> project = projectRepository.findById(uuid);
	
	if(!project.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	return new ProjectDTO(project.get());
}

public SkillDTO detailSkill(UUID uuid) {
	Optional<Skill> skill = skillRepository.findById(uuid);
	
	if(!skill.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	return new SkillDTO(skill.get());
}

public WelcomeDTO detailWelcome(UUID uuid) {
	Optional<Welcome> welcome = welcomeRepository.findById(uuid);
	
	if(!welcome.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	return new WelcomeDTO(welcome.get());
}

//METODOS PUT PARA CADA ENDPOINT

@Transactional
public Aboutme updateAboutme(UUID uuid, UpdateAboutmeForm updateAboutmeForm) {
	Optional<Aboutme> optAboutme = aboutmeRepository.findById(uuid);
	
	if(!optAboutme.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	Aboutme aboutme = optAboutme.get();
	aboutme.setMessage(updateAboutmeForm.getMessage());
	
	return aboutme;
}

@Transactional
public AvatarImage updateAvatarImage(UUID uuid, UpdateAvatarImageForm updateAvatarImageForm) {
	Optional<AvatarImage> optAvatar = avatarImageRepository.findById(uuid);
	
	if(!optAvatar.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	AvatarImage avatarImage = optAvatar.get();
	avatarImage.setImage(updateAvatarImageForm.getImage());
	
	return avatarImage;
}

@Transactional
public BannerImage updateBannerImage(UUID uuid, UpdateBannerImageForm updateBannerImageForm) {
	Optional<BannerImage> optBanner = bannerImageRepository.findById(uuid);
	
	if(!optBanner.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	BannerImage bannerImage = optBanner.get();
	bannerImage.setImage(updateBannerImageForm.getImage());
	
	return bannerImage;
}

@Transactional
public Education updateEducation(UUID uuid, UpdateEducationForm updateEducationForm) {
	Optional<Education> optEducation = educationRepository.findById(uuid);
	
	if(!optEducation.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	Education education = optEducation.get();
	education.setImage(updateEducationForm.getImage());
	
	return education;
}

@Transactional
public Experience updateExperience(UUID uuid, UpdateExperienceForm updateExperienceForm) {
	Optional<Experience> optExperience = experienceRepository.findById(uuid);
	
	if(!optExperience.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	Experience experience = optExperience.get();
	experience.setTitle(updateExperienceForm.getTitle());
	experience.setSubtitle(updateExperienceForm.getSubtitle());
	experience.setDetail(updateExperienceForm.getDetail());
	experience.setColor(updateExperienceForm.getColor());
	experience.setImage(updateExperienceForm.getImage());
	
	return experience;
}

@Transactional
public Network updateNetwork(UUID uuid, UpdateNetworkForm updateNetworkForm) {
	Optional<Network> optNetwork = networkRepository.findById(uuid);
	
	if(!optNetwork.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	Network network = optNetwork.get();
	network.setTitle(updateNetworkForm.getTitle());
	network.setIcon(updateNetworkForm.getIcon());
	network.setLink(updateNetworkForm.getLink());

	return network;
}

@Transactional
public Project updateProject(UUID uuid, UpdateProjectForm updateProjectForm) {
	Optional<Project> optProject = projectRepository.findById(uuid);
	
	if(!optProject.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	Project project = optProject.get();
	project.setTitle(updateProjectForm.getTitle());
	project.setDescription(updateProjectForm.getDescription());
	project.setLink(updateProjectForm.getLink());
	project.setImage(updateProjectForm.getImage());

	return project;
}

@Transactional
public Skill updateSkill(UUID uuid, UpdateSkillForm updateSkillForm) {
	Optional<Skill> optSkill = skillRepository.findById(uuid);
	
	if(!optSkill.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	Skill skill = optSkill.get();
	skill.setTitle(updateSkillForm.getTitle());
	skill.setPercentaje(updateSkillForm.getPercentaje());
	skill.setIcon(updateSkillForm.getIcon());
	skill.setColor(updateSkillForm.getColor());

	return skill;
}

@Transactional
public Welcome updateWelcome(UUID uuid, UpdateWelcomeForm updateWelcomeForm) {
	Optional<Welcome> optWelcome = welcomeRepository.findById(uuid);
	
	if(!optWelcome.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	Welcome welcome = optWelcome.get();
	welcome.setMessage(updateWelcomeForm.getMessage());

	return welcome;
}


//METODOS DELETE PARA CADA ENDPOINT

public void deleteAboutme(UUID uuid) {
	Optional<Aboutme> optAboutme = aboutmeRepository.findById(uuid);
	
	if(!optAboutme.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	aboutmeRepository.deleteById(uuid);
}

public void deleteAvatarImage(UUID uuid) {
	Optional<AvatarImage> optAvatarImage = avatarImageRepository.findById(uuid);
	
	if(!optAvatarImage.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	avatarImageRepository.deleteById(uuid);
}

public void deleteBannerImage(UUID uuid) {
	Optional<BannerImage> optBannerImage = bannerImageRepository.findById(uuid);
	
	if(!optBannerImage.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	bannerImageRepository.deleteById(uuid);
}

public void deleteEducation(UUID uuid) {
	Optional<Education> optEducation = educationRepository.findById(uuid);
	
	if(!optEducation.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	educationRepository.deleteById(uuid);
}

public void deleteExperience(UUID uuid) {
	Optional<Experience> optExperience = experienceRepository.findById(uuid);
	
	if(!optExperience.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	experienceRepository.deleteById(uuid);
}

public void deleteNetwork(UUID uuid) {
	Optional<Network> optNetwork = networkRepository.findById(uuid);
	
	if(!optNetwork.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	networkRepository.deleteById(uuid);
}

public void deleteProject(UUID uuid) {
	Optional<Project> optProject = projectRepository.findById(uuid);
	
	if(!optProject.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	projectRepository.deleteById(uuid);
}

public void deleteSkill(UUID uuid) {
	Optional<Skill> optSkill = skillRepository.findById(uuid);
	
	if(!optSkill.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	skillRepository.deleteById(uuid);
}

public void deleteWelcome(UUID uuid) {
	Optional<Welcome> optWelcome = welcomeRepository.findById(uuid);
	
	if(!optWelcome.isPresent())  {
		throw new NotFoundException(String.format("El recurso de id %s no fue encontrado", uuid));
	}
	
	welcomeRepository.deleteById(uuid);
}

}
