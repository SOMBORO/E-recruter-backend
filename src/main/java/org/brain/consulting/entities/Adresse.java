package org.brain.consulting.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable {
	
	private String localite;
	private String ville;
	private String rue;
	private String codePostal;
	
	public Adresse() {
		
	}
	
	public Adresse(String localite, String ville, String rue, String codePostal) {
		super();
		this.localite = localite;
		this.ville = ville;
		this.rue = rue;
		this.codePostal = codePostal;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Adresse [localite=" + localite + ", ville=" + ville + ", rue=" + rue + ", codePostal=" + codePostal
				+ "]";
	}
	
}
