package model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	private Dept department;
	
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	public Dept getDepartment() {
		return department;
	}

	public void setDepartment(Dept department) {
		this.department = department;
	}

	@Embedded
	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}

	@OneToOne
	public Rib getRib() {
		return rib;
	}

	public void setRib(Rib rib) {
		this.rib = rib;
	}

	private int version;
	

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Personne(int id, String nom, String prenom) {

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne() {

	}

	@Id
	@Column(name="secu")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="firstname")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="lastname")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String toString() {
		String str="Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
		str+=(rib==null)?"":rib.toString();
		str+=(adr==null)?"":adr.toString();
		return str;
	}

}
