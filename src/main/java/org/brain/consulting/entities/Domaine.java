package org.brain.consulting.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Domaine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idDomaine;
	private String nom;
	
	public Domaine() {
		
	}
	
	public Domaine(String nom) {
		super();
		this.nom = nom;
	}

	public Long getIdDomaine() {
		return idDomaine;
	}

	public void setIdDomaine(Long idDomaine) {
		this.idDomaine = idDomaine;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
