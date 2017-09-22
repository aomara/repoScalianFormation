package gestionPatient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

//import dao.Patient;
//import metier.Personne;

public class DAOPatient {
/*
 */
	Patient patient = new Patient();
	public static void creerPatient(Patient patient) {
		
		try {
			java.sql.Connection connect = null;
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "root");
			
			PreparedStatement ps = connect.prepareStatement("insert into patient VALUES (?, ?, ?)");
			ps.setInt(1, patient.getId());
			ps.setString(2, patient.getNom());
			ps.setString(3, patient.getPrenom());
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("OK!! patient créé");
			
	}
	public static   Patient recupererPatientById(int id) throws Exception {
		
		Patient patient =new Patient();
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","root");
		PreparedStatement ps = conn.prepareStatement("select * from patient where id like ?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			patient = new Patient();
			patient.setId(rs.getInt("id"));
			patient.setNom(rs.getString("Nom"));
			patient.setPrenom(rs.getString("Prenom"));			
		} 
	
	
	return patient;
	}
	
	
	public static ArrayList<Patient> listAllPatient() throws Exception {
		ArrayList<Patient> listPatient = new ArrayList<Patient>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "root");
		String str = "select * from patient";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(str);

		while (rs.next()) {
			
			Patient patient =new Patient();
			patient.setId(rs.getInt("id")); 
			patient.setNom(rs.getString("nom")) ;
			patient.setPrenom( rs.getString("prenom")); 
			listPatient.add(patient);									
		}
		return listPatient;
	}
	
	/*
	 * selectionner par le nom
	 */
	public String selectPatientbyName(String patient) throws Exception {
		String reponse = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "root");
		String str = "select * from personne where nom = ? ";
		PreparedStatement ps=conn.prepareStatement(str);
		ps.setString(1,patient);
		
		ResultSet rs =ps.executeQuery();

		while (rs.next()) {
			reponse += rs.getInt(1) + "\t";
			reponse += rs.getString("nom") + "\t";
			reponse += rs.getString("prenom") + "\n";
		}
		return reponse;
	}
	
	public static void mettrePatientLhistorique() {
		
	}
}
