package org.brain.consulting;

import java.util.Date;

import org.brain.consulting.entities.Admin;
import org.brain.consulting.entities.Adresse;
import org.brain.consulting.entities.Categorie;
import org.brain.consulting.entities.Client;
import org.brain.consulting.entities.Domaine;
import org.brain.consulting.entities.Employe;
import org.brain.consulting.entities.Mission;
import org.brain.consulting.entities.Offre;
import org.brain.consulting.entities.Proposition;
import org.brain.consulting.entities.Question;
import org.brain.consulting.entities.Questionnaire;
import org.brain.consulting.entities.Sujet;
import org.brain.consulting.repositories.AdminRepository;
import org.brain.consulting.repositories.CategorieRepository;
import org.brain.consulting.repositories.ClientRepository;
import org.brain.consulting.repositories.DomaineRepository;
import org.brain.consulting.repositories.EmployeRepository;
import org.brain.consulting.repositories.MissionRepository;
import org.brain.consulting.repositories.OffreRepository;
import org.brain.consulting.repositories.QuestionRepository;
import org.brain.consulting.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalBackendApplication implements CommandLineRunner {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private OffreRepository offreRepository;
	@Autowired
	private DomaineRepository domaineRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private MissionRepository missionRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FinalBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Admin admin = new Admin(Long.parseLong("12345678"), "email", "password", "nomPrenom", "typeUser", "poste");
		adminRepository.save(admin);
		Client client = new Client("WAKAHAW", "wakahaw@gmail.com", 54278384, new Adresse("Lac Victoria", "Tunis", "152", "2066"));
		clientRepository.save(client);
		Domaine domaine = new Domaine("Informatique");
		domaineRepository.save(domaine);
		Categorie categorie = new Categorie("Développement web");
		categorie.setDomaine(domaine);
		categorieRepository.save(categorie);
		
		Sujet sujet = new Sujet("Java EE");
		sujet.setCategorie(categorie);
		
		Question question = new Question("type1", 3, "texte");
		Proposition proposition = new Proposition("texte", "reponse");
		question.addProposition(proposition);
//		questionRepository.save(question);
		
		Questionnaire ques = new Questionnaire("titre", "niveau", 3, new Date(), new Date(), 0);
		ques.addQuestion(question);
		ques.setAdmin(admin);
		ques.addSujet(sujet);
		questionnaireRepository.save(ques);
		
		Offre offre = new Offre(Long.parseLong("12345678"), "type", "libelle", "description", new Date(), new Date(), 2);
		offre.setAdmin(admin);
		offre.setDomaine(domaine);
		offre.addQuestionnaire(ques);
		offre.setClient(client);
		offreRepository.save(offre);
		
		Employe employe = new Employe(Long.parseLong("123456"), "email", "password", "nomPrenom", new Adresse("localite", "ville", "rue", "codePostal"), "typeUser", 54278384, "lienCV", "lienLettreMotivation", 2, "formation", 2019, "statut", new Date(), "typeContrat", "dureeContrat", 2500, "typeEmploye");
		employeRepository.save(employe);
		
		Mission mission = new Mission(Long.parseLong("12345"), "description", "lieu");
		mission.setAdmin(admin);
		mission.addEmploye(employe, "etat");
		missionRepository.save(mission);
		
	}
}
