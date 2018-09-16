package org.brain.consulting.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sujet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idSujet;
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="categorie", nullable=false)
	private Categorie categorie;
	
	public Sujet() {
		
	}
	
	public Sujet(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Long getIdSujet() {
		return idSujet;
	}

	public void setIdSujet(Long idSujet) {
		this.idSujet = idSujet;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
