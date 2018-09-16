package org.brain.consulting.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proposition {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idProposition;
	private String texte;
	private String reponse;
	
	public Proposition() {
		
	}
	
	public Proposition(String texte, String reponse) {
		super();
		this.texte = texte;
		this.reponse = reponse;
	}
	public Long getIdProposition() {
		return idProposition;
	}
	public void setIdProposition(Long idProposition) {
		this.idProposition = idProposition;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
}
