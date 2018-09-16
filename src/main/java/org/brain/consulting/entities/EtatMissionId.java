package org.brain.consulting.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EtatMissionId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="employe_cin")
	private Long cin;
	@Column(name="mission_ref")
	private Long refMission;
	
	public EtatMissionId() {
		
	}
	
	public EtatMissionId(Long cin, Long refMission) {
		this.cin = cin;
		this.refMission = refMission;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
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
		EtatMissionId other = (EtatMissionId) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (refMission == null) {
			if (other.refMission != null)
				return false;
		} else if (!refMission.equals(other.refMission))
			return false;
		return true;
	}

}
