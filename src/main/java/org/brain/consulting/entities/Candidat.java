package org.brain.consulting.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("candidat")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Candidat extends User {
	@Column(name="tel")
	private int tel;
	@Column(name="lienCV")
	private String lienCV;
	@Column(name="lienLettreMotivation")
	private String lienLettreMotivation;
	@Column(name="nbExperiences")
	private int nbExperiences;
	@Column(name="formation")
	private String formation;
	@Column(name="anneeDiplome")
	private int anneeDiplome;
	@Column(name="statut")
	private String statut;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="CANDIDAT_COMPETENCES",
			joinColumns = { @JoinColumn(name = "cin") },
			inverseJoinColumns = { @JoinColumn(name = "idOutil") }
	)
	private List<Competence> competences = new ArrayList<>();
	
	public Candidat() {
		
	}
	
	public Candidat(Long cin, String email, String password, String nomPrenom, Adresse adresse, String typeUser,
			int tel, String lienCV, String lienLettreMotivation, int nbExperiences, String formation, int anneeDiplome,
			String statut) {
		super(cin, email, password, nomPrenom, adresse, typeUser);
		this.tel = tel;
		this.lienCV = lienCV;
		this.lienLettreMotivation = lienLettreMotivation;
		this.nbExperiences = nbExperiences;
		this.formation = formation;
		this.anneeDiplome = anneeDiplome;
		this.statut = statut;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getLienCV() {
		return lienCV;
	}

	public void setLienCV(String lienCV) {
		this.lienCV = lienCV;
	}

	public String getLienLettreMotivation() {
		return lienLettreMotivation;
	}

	public void setLienLettreMotivation(String lienLettreMotivation) {
		this.lienLettreMotivation = lienLettreMotivation;
	}

	public int getNbExperiences() {
		return nbExperiences;
	}

	public void setNbExperiences(int nbExperiences) {
		this.nbExperiences = nbExperiences;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public int getAnneeDiplome() {
		return anneeDiplome;
	}

	public void setAnneeDiplome(int anneeDiplome) {
		this.anneeDiplome = anneeDiplome;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + anneeDiplome;
		result = prime * result + ((competences == null) ? 0 : competences.hashCode());
		result = prime * result + ((formation == null) ? 0 : formation.hashCode());
		result = prime * result + ((lienCV == null) ? 0 : lienCV.hashCode());
		result = prime * result + ((lienLettreMotivation == null) ? 0 : lienLettreMotivation.hashCode());
		result = prime * result + nbExperiences;
		result = prime * result + ((statut == null) ? 0 : statut.hashCode());
		result = prime * result + tel;
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
		Candidat other = (Candidat) obj;
		if (anneeDiplome != other.anneeDiplome)
			return false;
		if (competences == null) {
			if (other.competences != null)
				return false;
		} else if (!competences.equals(other.competences))
			return false;
		if (formation == null) {
			if (other.formation != null)
				return false;
		} else if (!formation.equals(other.formation))
			return false;
		if (lienCV == null) {
			if (other.lienCV != null)
				return false;
		} else if (!lienCV.equals(other.lienCV))
			return false;
		if (lienLettreMotivation == null) {
			if (other.lienLettreMotivation != null)
				return false;
		} else if (!lienLettreMotivation.equals(other.lienLettreMotivation))
			return false;
		if (nbExperiences != other.nbExperiences)
			return false;
		if (statut == null) {
			if (other.statut != null)
				return false;
		} else if (!statut.equals(other.statut))
			return false;
		if (tel != other.tel)
			return false;
		return true;
	}
	
}
