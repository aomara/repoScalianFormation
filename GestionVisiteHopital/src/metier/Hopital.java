package metier;

import java.util.ArrayList;
import java.util.LinkedList;

import gestionPatient.DAOPatient;
import gestionPatient.Patient;

public class Hopital {
	
	// attributs
	private String secretaire ="";
	public Patient patient= new Patient();
	// file d'attente liste FIFO : file d'attente de patients
	LinkedList<Patient> lpatient;//= new LinkedList<Patient>();
	Salle salle= null;
	
	// constructeur
	//public Hopital(String secretaire, Salle salle, LinkedList<Patient> lpatient) {
	public Hopital(String secretaire, Salle salle) {
		//super();
		this.secretaire = secretaire;
		this.salle = salle;
		this.lpatient = new LinkedList<Patient>();
	}

	
		public  Patient afficherUnPatient() throws Exception {
		int x= this.patient.getId();
		Patient p = DAOPatient.recupererPatientById(x);
		return p;
	}
		
		public  void afficherListeAttente() throws Exception {	
			ArrayList<Patient> allPatient = DAOPatient.listAllPatient();
			for (Patient patient : allPatient)
				System.out.println(patient.toString());
			
		}
		
		
	
	public void changerJournee () {
		lpatient.clear();
	}
	
	
	public void ajouterPatient (Patient patient) throws Exception {
		if (DAOPatient.recupererPatientById(patient.getId()) == null)
			DAOPatient.creerPatient(patient);
		lpatient.add(patient);
	}
	/* Envoyer un patient dans une salle
	 * on verifie si la salle est innocupée i.e que le patient n'est pas dans la liste
	 * des visites
	 * 
	 */
	public String  envoyerUnPatient(Salle s) {
		 String str = " la salle ";
		Patient patient = lpatient.poll();
		if ((patient != null) && salle.sallePrete(patient))
		 str+= " est prete";
		else 
			str+= " n'est pas prete ";
		return str;
			
	}
	

	
}
