package model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Dept {

	private int id;
	private String nom;
	private int version;
	private Collection<Personne> lst;
	
	@OneToMany(mappedBy="department",fetch=FetchType.EAGER)
	public Collection<Personne> getLst() {
		return lst;
	}

	public void setLst(Collection<Personne> lst) {
		this.lst = lst;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Id
	public int getId() {
		return id;
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

	public Dept() {

	}

	public Dept(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", nom=" + nom + ", version=" + version + "]";
	}
}
