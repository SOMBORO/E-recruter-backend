package org.brain.consulting.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCategorie;
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="domaine", nullable=false)
	private Domaine domaine;
	
	public Categorie() {
		
	}
	
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Domaine getDomaine() {
		return domaine;
	}
	
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

}
