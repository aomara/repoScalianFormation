package gestionPatient;

import java.io.Serializable;
import java.util.LinkedList;



public class Patient implements Serializable{
	
// attributs	
private String nom;
private String prenom;
private int id;

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
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

// constructeurs
public Patient() {
	
}
public Patient(String nom, String prenom, int id) {
	//super();
	this.nom = nom;
	this.prenom = prenom;
	this.id = id;
}


@Override
public String toString() {
	return  id + " " + nom + " "  + prenom + "\t" ;
}


}
