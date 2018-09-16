package org.brain.consulting.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Employe extends Candidat {
	
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date dateEmbauche;
	private String typeContrat;
	private String dureeContrat;
	private double salaire;
	private String typeEmploye;
	
	@OneToMany(
			mappedBy="employe",
			cascade=CascadeType.ALL,
			orphanRemoval=true
	)
	private List<EtatMission> missions = new ArrayList<>();
	
	public Employe() {
		
	}

	public Employe(Long cin, String email, String password, String nomPrenom, Adresse adresse, String typeUser, int tel,
			String lienCV, String lienLettreMotivation, int nbExperiences, String formation, int anneeDiplome,
			String statut, Date dateEmbauche, String typeContrat, String dureeContrat, double salaire, String typeEmploye) {
		super(cin, email, password, nomPrenom, adresse, typeUser, tel, lienCV, lienLettreMotivation, nbExperiences,
				formation, anneeDiplome, statut);
		this.dateEmbauche = dateEmbauche;
		this.typeContrat = typeContrat;
		this.dureeContrat = dureeContrat;
		this.salaire = salaire;
		this.typeEmploye = typeEmploye;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public String getDureeContrat() {
		return dureeContrat;
	}

	public void setDureeContrat(String dureeContrat) {
		this.dureeContrat = dureeContrat;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public String getTypeEmploye() {
		return typeEmploye;
	}

	public void setTypeEmploye(String typeEmploye) {
		this.typeEmploye = typeEmploye;
	}

	public List<EtatMission> getMissions() {
		return missions;
	}

	public void setMissions(List<EtatMission> missions) {
		this.missions = missions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateEmbauche == null) ? 0 : dateEmbauche.hashCode());
		result = prime * result + ((dureeContrat == null) ? 0 : dureeContrat.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salaire);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((typeContrat == null) ? 0 : typeContrat.hashCode());
		result = prime * result + ((typeEmploye == null) ? 0 : typeEmploye.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (dateEmbauche == null) {
			if (other.dateEmbauche != null)
				return false;
		} else if (!dateEmbauche.equals(other.dateEmbauche))
			return false;
		if (dureeContrat == null) {
			if (other.dureeContrat != null)
				return false;
		} else if (!dureeContrat.equals(other.dureeContrat))
			return false;
		if (Double.doubleToLongBits(salaire) != Double.doubleToLongBits(other.salaire))
			return false;
		if (typeContrat == null) {
			if (other.typeContrat != null)
				return false;
		} else if (!typeContrat.equals(other.typeContrat))
			return false;
		if (typeEmploye == null) {
			if (other.typeEmploye != null)
				return false;
		} else if (!typeEmploye.equals(other.typeEmploye))
			return false;
		return true;
	}

}
