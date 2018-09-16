package org.brain.consulting.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idQuestion;
	private String type;
	private int nbPropositions;
	private String texte;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="question", nullable=false)
	private List<Proposition> propositions = new ArrayList<>();
	
	public Question() {
		
	}
	
	public Question(String type, int nbPropositions, String texte) {
		super();
		this.type = type;
		this.nbPropositions = nbPropositions;
		this.texte = texte;
	}

	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNbPropositions() {
		return nbPropositions;
	}

	public void setNbPropositions(int nbPropositions) {
		this.nbPropositions = nbPropositions;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public List<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}
	
	public void addProposition(Proposition proposition) {
		this.propositions.add(proposition);
	}
	
	public void removeProposition(Proposition proposition) {
		this.propositions.remove(proposition);
	}
	
	public void updateProposition(Proposition nouvelle) {
		for(Proposition ancienne : this.propositions) {
			if(ancienne.getIdProposition().equals(nouvelle.getIdProposition())) {
				this.propositions.remove(ancienne);
				this.addProposition(nouvelle);
				break;
			}
		}
	}

}
