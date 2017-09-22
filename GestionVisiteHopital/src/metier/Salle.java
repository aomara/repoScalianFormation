package metier;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import gestionPatient.Patient;
import gestionPatient.Visite;

public class Salle {
	
	private static int numSalle;
	private String medecin;
	private ArrayList<Visite> lVisite; 
	private Hopital hopital;

	private final static double tarif = 50;

public Salle(int numSalle, String medecin,Hopital hopital) {
	
	this.numSalle = numSalle;
	this.medecin = medecin;
	this.hopital = hopital;
	lVisite= new ArrayList<Visite>();
}






public int getNumSalle() {
	return numSalle;
}



public void setNumSalle(int numSalle) {
	this.numSalle = numSalle;
}



public String getMedecin() {
	return medecin;
}



public void setMedecin(String medecin) {
	this.medecin = medecin;
}



public ArrayList<Visite> getlVisite() {
	return lVisite;
}



public void setlVisite(ArrayList<Visite> lVisite) {
	this.lVisite = lVisite;
}

public static int salleDisponible(int num) {
	numSalle = num;
/*
 *  on vide l'element en visite et on verifier si on met une visite en base
 *  si le  cota est atteint ou si on veut liberere la salle
 */
	String dispo;
//dispo = envoyerUnPatient(num);

return numSalle;
}


public String afficherLesVisites () {
	String resVisite = " total des visites:";
	for (int i=0; i<lVisite.size(); i++) {
		Visite v = lVisite.get(i);
		resVisite += "\n"+v.getDate()+"\t"+v.getNumPatient()+"\t Salle "+numSalle+"\t Medecin: "+medecin+"\t "+tarif;
	}
	return resVisite;
}



@Override
public String toString() {
	return "Salle [numSalle=" + numSalle 
			+ ", medecin=" + medecin 
			+ ", lVisite=" + lVisite 
			+ ", hopital=" + hopital
			+ "]";
}

public boolean sallePrete (Patient patient) {
	boolean ok =false;
	try {
	Visite v = new Visite(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()), patient.getId(), medecin, tarif, numSalle);
	lVisite.add(v);
	ok=true;
	}catch(Exception e) {
		
	}
	return ok;
}



}
