package model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Dept {
	
private int id;
private String nom;
private int version;
private Collection<Personne> lst;



public void setLst(Collection<Personne> lst) {
	this.lst = lst;
}



@OneToMany(mappedBy="departement")
public Collection<Personne> getLst() {
	return lst;
}



public void setLst(List<Personne> lst) {
	this.lst = lst;
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


@Version
public int getVersion() {
	return version;
}



public void setVersion(int version) {
	this.version = version;
}



public Dept(int id, String nom) {
	super();
	this.id = id;
	this.nom = nom;
}



@Override
public String toString() {
	return "Departement [id=" + id + ", nom=" + nom + ", version=" + version + "]";
}





}
