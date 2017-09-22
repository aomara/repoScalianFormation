package model;

public class Personne {
private String nom;
private String prenom;

private Civilite c;

public Personne(String nom, String prenom, Civilite mr) {
	this.nom = nom;
	this.prenom = prenom;
	this.c = mr; 
}

@Override
public String toString() {
	return "Personne [nom=" + nom + ", prenom=" + prenom + ", c=" + c + "]";
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

public Civilite getC() {
	return c;
}

public void setC(Civilite c) {
	this.c = c;
}

}
