package org.brain.consulting.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Offre {
	@Id
	private Long refOffre;
	private String type;
	private String libelle;
	private String description;
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date datePublication;
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date duree;
	private int nbPostes;
	
	@ManyToOne
	@JoinColumn(name="admin", nullable=false)
	private Admin admin;
	
	@ManyToOne
	@JoinColumn(name="client", nullable=false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="domaine", nullable=false)
	private Domaine domaine;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="OFFRE_QUESTIONNAIRES",
			joinColumns = { @JoinColumn(name = "refOffre") },
			inverseJoinColumns = { @JoinColumn(name = "idQuestionnaire") }
	)
	private List<Questionnaire> questionnaires = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="OFFRE_CRITERES",
			joinColumns = { @JoinColumn(name = "refOffre") },
			inverseJoinColumns = { @JoinColumn(name = "idCritere") }
	)
	private List<Critere> criteres = new ArrayList<>();
	
	public Offre() {
		
	}

	public Offre(Long refOffre, String type, String libelle, String description, Date datePublication, Date duree,
			int nbPostes) {
		super();
		this.refOffre = refOffre;
		this.type = type;
		this.libelle = libelle;
		this.description = description;
		this.datePublication = datePublication;
		this.duree = duree;
		this.nbPostes = nbPostes;
	}

	public Long getRefOffre() {
		return refOffre;
	}

	public void setRefOffre(Long refOffre) {
		this.refOffre = refOffre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	public int getNbPostes() {
		return nbPostes;
	}

	public void setNbPostes(int nbPostes) {
		this.nbPostes = nbPostes;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Domaine getDomaine() {
		return domaine;
	}
	
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	
	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}
	
	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	
	public void addQuestionnaire(Questionnaire questionnaire) {
		this.questionnaires.add(questionnaire);
	}
	
	public void removeQuestionnaire(Questionnaire questionnaire) {
		this.questionnaires.remove(questionnaire);
	}
	
	public List<Critere> getCriteres() {
		return criteres;
	}
	
	public void addCritere(Critere critere) {
		this.criteres.add(critere);
	}
	
	public void removeCritere(Critere critere) {
		this.criteres.remove(critere);
	}

}
