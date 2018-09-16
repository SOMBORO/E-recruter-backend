package org.brain.consulting.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Questionnaire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idQuestionnaire;
	private String titre;
	private String niveau;
	private int nbQuestions;
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date dateCreation;
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date dateUpdate;
	private int duree;
	
	@ManyToOne
	@JoinColumn(name="admin", nullable=false)
	private Admin admin;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="questionnaire", nullable=false)
	private List<Question> questions = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="questionnaire", nullable=false)
	private List<Sujet> sujets = new ArrayList<>();
	
	public Questionnaire() {
		
	}

	public Questionnaire(String titre, String niveau, int nbQuestions, Date dateCreation, Date dateUpdate, int duree) {
		super();
		this.titre = titre;
		this.niveau = niveau;
		this.nbQuestions = nbQuestions;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
		this.duree = duree;
	}

	public Long getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(Long idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getNbQuestions() {
		return nbQuestions;
	}

	public void setNbQuestions(int nbQuestions) {
		this.nbQuestions = nbQuestions;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	
	public void removeQuestion(Question question) {
		this.questions.remove(question);
	}
	
	public void updateQuestion(Question nouvelle) {
		for(Question ancienne : this.questions) {
			if(ancienne.getIdQuestion().equals(nouvelle.getIdQuestion())) {
				this.questions.remove(ancienne);
				this.addQuestion(nouvelle);
				break;
			}
		}
	}

	public List<Sujet> getSujets() {
		return sujets;
	}

	public void setSujets(List<Sujet> sujets) {
		this.sujets = sujets;
	}
	
	public void addSujet(Sujet sujet) {
		this.sujets.add(sujet);
	}
	
	public void removeSujet(Sujet sujet) {
		this.sujets.remove(sujet);
	}
	
	public void updateSujet(Sujet nouvelle) {
		for(Sujet ancienne : this.sujets) {
			if(ancienne.getIdSujet().equals(nouvelle.getIdSujet())) {
				this.sujets.remove(ancienne);
				this.addSujet(nouvelle);
				break;
			}
		}
	}

}
