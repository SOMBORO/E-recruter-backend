package org.brain.consulting.controllers;

import java.util.List;

import org.brain.consulting.entities.Employe;
import org.brain.consulting.entities.Mission;
import org.brain.consulting.entities.Offre;
import org.brain.consulting.entities.Question;
import org.brain.consulting.entities.Questionnaire;
import org.brain.consulting.repositories.EmployeRepository;
import org.brain.consulting.repositories.MissionRepository;
import org.brain.consulting.repositories.OffreRepository;
import org.brain.consulting.repositories.QuestionRepository;
import org.brain.consulting.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plateforme")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class QuestionController {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	@Autowired
	private OffreRepository offreRepository;
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private EmployeRepository employeRepository;
	
	@GetMapping("/questions")
	public List<Question> getAll(){
		return questionRepository.findAll();
	}
	
	@GetMapping("/questionnaires")
	public List<Questionnaire> getQ(){
		return questionnaireRepository.findAll();
	}
	
	@GetMapping("/offres")
	public List<Offre> getO(){
		return offreRepository.findAll();
	}
	
	@GetMapping("/missions")
	public List<Mission> getM(){
		return missionRepository.findAll();
	}
	
	@GetMapping("/employes")
	public List<Employe> getE(){
		return employeRepository.findAll();
	}

}
