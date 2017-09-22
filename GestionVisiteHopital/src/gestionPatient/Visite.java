package gestionPatient;

import java.io.Serializable;
import java.util.Date;
import metier.Salle;

public class Visite implements Serializable {
	
	private String medecin;
	private double  tarif;	
	private int numPatient;// id_patient
	private int numSalle;
	private String date;
	private int id; // id de la visite
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNumPatient() {
		return numPatient;
	}
	public void setNumPatient(int numPatient) {
		this.numPatient = numPatient;
	}
		
	
	public String getMedecin() {
		return medecin;
	}
	public void setMedecin(String medecin) {
		this.medecin = medecin;
	}
		
	public Visite(String date, int numPatient, String medecin, double tarif, int numSalle) {
		this.date = date;
		this.numPatient = numPatient;
		this.medecin = medecin;
		this.setTarif(tarif);
		this.setNumSalle(numSalle);
	}
	
	private void setTarif(double tarif) {
		// TODO Auto-generated method stub
		
	}
	public Visite() {
		
	}
	
	public double getTarif() {
		return tarif;
	}
	@Override
	public String toString() {
		return "Visite [medecin=" + medecin + ", tarif=" + tarif + ", numPatient=" + numPatient + ", numSalle="
				+ numSalle + ", date=" + date + "]";
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	public int getNumSalle() {
		return numSalle;
	}
	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}
	
	
	
	
}
