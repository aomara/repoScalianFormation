package model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="person")
public class Personne {
	
	private int id;
	private String nom;
	private String prenom;
	
	private Rib rib;
	private Adresse adr;
	
	private Dept departement;
	
	@Embedded
	public Adresse getAdr() {
		return adr;
	}

	
	
	public Dept getDepartement() {
		return departement;
	}



	public void setDepartement(Dept departement) {
		this.departement = departement;
	}



	public void setAdr(Adresse adr) {
		this.adr = adr;
	}

	private int version;
	
	@Id
	public int getId() {
		return id;
	}
	
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Personne() {
		
	}
	
	
	@OneToOne
	public Rib getRib() {
		return rib;
	}

	public Personne(int id, String nom, String prenom, Rib rib) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.rib = rib;
}

	public Personne(int id, String nom, String prenom) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	
}

	public void setRib(Rib rib) {
		this.rib = rib;
	}

	@Override
	public String toString() {
		String str = id + ", nom=" + nom + ", prenom=" + prenom ;
		//if()
		return str;
		
	}
	
	
	

}
