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
public class Mission {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long refMission;
	private String description;
	private String lieu;
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date dateDebut;
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name="admin", nullable=false)
	private Admin admin;
	
	@OneToMany(
			mappedBy="mission",
			cascade=CascadeType.ALL,
			orphanRemoval=true
	)
	private List<EtatMission> employes = new ArrayList<>();
	
	public Mission() {
		
	}
	
	public Mission(Long refMission, String description, String lieu) {
		super();
		this.refMission = refMission;
		this.description = description;
		this.lieu = lieu;
	}

	public Mission(Long refMission, String description, String lieu, Date dateDebut, Date dateFin) {
		super();
		this.refMission = refMission;
		this.description = description;
		this.lieu = lieu;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getRefMission() {
		return refMission;
	}

	public void setRefMission(Long refMission) {
		this.refMission = refMission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void addEmploye(Employe employe, String etat) {
		EtatMission etatMision = new EtatMission(employe, this, etat);
		this.employes.add(etatMision);
		employe.getMissions().add(etatMision);
	}
	
//	public void removeEmploye(Employe employe) {
//		for(EtatMission etat : this.employes) {
//			if(etat.getEmploye().equals(employe) && etat.getMission().equals(this)) {
//				this.employes.remove(etat);
//				etat.getEmploye().getMissions().remove(etat);
//				etat.setMission(null);
//				etat.setEmploye(null);
//			}
//		}
//	}
	
//	public List<EtatMission> getEmployes(){
//		return employes;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
		result = prime * result + ((refMission == null) ? 0 : refMission.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mission other = (Mission) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		if (refMission == null) {
			if (other.refMission != null)
				return false;
		} else if (!refMission.equals(other.refMission))
			return false;
		return true;
	}
	
}
