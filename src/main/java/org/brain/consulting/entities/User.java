package org.brain.consulting.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public class User {
	@Id
	@Column(name="cin")
	private Long cin;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="nomPrenom")
	private String nomPrenom;
	
	@Column(name="typeUser")
	private String typeUser;
	
	@Embedded
	private Adresse adresse;
	
	public User() {
		
	}
	
	public User(Long cin, String email, String password, String nomPrenom, String typeUser) {
		super();
		this.cin = cin;
		this.email = email;
		this.password = password;
		this.nomPrenom = nomPrenom;
		this.typeUser = typeUser;
	}
	
	public User(Long cin, String email, String password, String nomPrenom, Adresse adresse, String typeUser) {
		super();
		this.cin = cin;
		this.email = email;
		this.password = password;
		this.nomPrenom = nomPrenom;
		this.adresse = adresse;
		this.typeUser = typeUser;
	}
	
	public Long getCin() {
		return cin;
	}
	
	public void setCin(Long cin) {
		this.cin = cin;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNomPrenom() {
		return nomPrenom;
	}
	
	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public String getTypeUser() {
		return typeUser;
	}
	
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
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
		User other = (User) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [cin=" + cin + ", email=" + email + ", password=" + password + ", nomPrenom=" + nomPrenom
				+ ", typeUser=" + typeUser + "]";
	}
	
}
