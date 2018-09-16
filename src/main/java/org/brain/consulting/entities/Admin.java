package org.brain.consulting.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User {
	@Column(name="poste")
	private String poste;

	public Admin() {
		
	}
	
	public Admin(Long cin, String email, String password, String nomPrenom, String typeUser, String poste) {
		super(cin, email, password, nomPrenom, typeUser);
		this.poste = poste;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((poste == null) ? 0 : poste.hashCode());
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
		Admin other = (Admin) obj;
		if (poste == null) {
			if (other.poste != null)
				return false;
		} else if (!poste.equals(other.poste))
			return false;
		return true;
	}
	
	
}
