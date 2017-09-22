package gestionPatient;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DAOVisite {

	/*
	 * recupererListeVisites();
	 * ajouterVisiteDansBd(ArrayList<Visite> desVisites);
	 * 
	 */
	
	public static ArrayList<Visite> recupererListeVisites(){
		ArrayList<Visite> desVisites = new ArrayList<Visite>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","root");
			Statement st = conn.createStatement();
			
			ResultSet rs= st.executeQuery("select * from visite");
			
			while(rs.next()){
				Visite v = new Visite();
				v.setId(rs.getInt("id"));
				v.setNumPatient(rs.getInt("id_patient"));
				v.setDate(rs.getString("date"));
				v.setMedecin(rs.getString("medecin"));
				v.setNumSalle(rs.getInt("numSalle"));
				v.setTarif(rs.getInt("tarif"));
				
				desVisites.add(v);

			}
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		
		return desVisites;
	}	
	

	public static String ajouterVisiteDansBd(ArrayList<Visite> desVisites){
		String str="La visite ";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","root");
				for (Visite v : desVisites) {
					PreparedStatement ps = conn.prepareStatement("insert into visite(id_patient ,date, medecin, numSalle, tarif)"
							+ " values (?, ?, ?, ?, ?)");
					//ps.setInt(1,v.getId());
					ps.setInt(1,v.getNumPatient());
					ps.setString(2,v.getDate());
					ps.setString(3,v.getMedecin());
					ps.setInt(4,v.getNumSalle());
					ps.setDouble(5,v.getTarif());
					ps.executeUpdate();
					str+="est mise dans la base ";
				}
				return str;
				
			} catch (Exception e) { 
				e.printStackTrace(); 
				return str+=" n'est pas mise dans la base --> erreur " ;
			}	
	}
	
	
	
	
}
