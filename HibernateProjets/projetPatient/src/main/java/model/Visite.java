package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="visite")
public class Visite {
	private int id;
	private String date;
	private double prix;
	
	private int version;
	
	public Visite() {
		
	}

	
	
	
	public Visite(int id, String date, double prix) {
		super();
		this.id = id;
		this.date = date;
		this.prix = prix;
	}




	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	public Visite(int id, double prix) {
		super();
		this.id = id;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Visite [id=" + id + ", date=" + date + ", prix=" + prix + "]";
	}
	
	

}
