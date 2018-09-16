package org.brain.consulting.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Competence {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idOutil;
	private String libelle;
	private String type;
	
	public Competence() {
		
	}
	
	public Competence(String libelle, String type) {
		super();
		this.libelle = libelle;
		this.type = type;
	}

	public Long getIdOutil() {
		return idOutil;
	}

	public void setIdOutil(Long idOutil) {
		this.idOutil = idOutil;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
