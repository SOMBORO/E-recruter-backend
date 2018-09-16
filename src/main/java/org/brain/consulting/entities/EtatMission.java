package org.brain.consulting.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class EtatMission {
	
	@EmbeddedId
	private EtatMissionId id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("cin")
	private Employe employe;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("refMission")
	private Mission mission;
	
	@Column(name="etat")
	private String etat;
	
	public EtatMission() {
		
	}
	
	public EtatMission(Employe employe, Mission mission, String etat) {
		this.employe = employe;
		this.mission = mission;
		this.etat = etat;
		this.id = new EtatMissionId(employe.getCin(), mission.getRefMission());
	}

//	public Employe getEmploye() {
//		return employe;
//	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

//	public Mission getMission() {
//		return mission;
//	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
