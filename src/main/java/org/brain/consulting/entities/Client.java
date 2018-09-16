package org.brain.consulting.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idClient;
	private String nom;
	private String email;
	private int tel;
	@Embedded
	private Adresse adresse;
	
	@OneToMany(mappedBy="client", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Offre> offres = new ArrayList<>();
	
	public Client() {
		
	}
	
	public Client(String nom, String email, int tel, Adresse adresse) {
		super();
		this.nom = nom;
		this.email = email;
		this.tel = tel;
		this.adresse = adresse;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}
	
	public void addOffre(Offre offre) {
		this.offres.add(offre);
	}
	
	public void removeOffre(Offre offre) {
		this.offres.remove(offre);
	}
	
	public void updateOffre(Offre nouvelle) {
		for(Offre ancienne : this.offres) {
			if(ancienne.getRefOffre().equals(nouvelle.getRefOffre())) {
				this.offres.remove(ancienne);
				this.addOffre(nouvelle);
				break;
			}
		}
	}

}
