package org.brain.consulting.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Critere {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCritere;
	private String niveauEtude;
	private int nbExperiences;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="CRITERE_COMPETENCES",
			joinColumns = { @JoinColumn(name = "idCritere") },
			inverseJoinColumns = { @JoinColumn(name = "idOutil") }
	)
	private List<Competence> competences = new ArrayList<>();
	
	public Critere() {
		
	}

	public Critere(String niveauEtude, int nbExperiences) {
		super();
		this.niveauEtude = niveauEtude;
		this.nbExperiences = nbExperiences;
	}

	public Long getIdCritere() {
		return idCritere;
	}

	public void setIdCritere(Long idCritere) {
		this.idCritere = idCritere;
	}

	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public int getNbExperiences() {
		return nbExperiences;
	}

	public void setNbExperiences(int nbExperiences) {
		this.nbExperiences = nbExperiences;
	}
	
	public List<Competence> getCompetences() {
		return competences;
	}
	
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}
	
	public void addCompetence(Competence competence) {
		this.competences.add(competence);
	}
	
	public void removeCompetence(Competence competence) {
		this.competences.remove(competence);
	}

}
