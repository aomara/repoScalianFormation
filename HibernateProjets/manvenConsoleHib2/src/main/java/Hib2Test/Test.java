package Hib2Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personne;

public class Test {

	public static void main(String[] args) {
		test1();
	
	}
	
	static void test1() {
		
		//System.out.println("je suis mavenConsoleHib2");
		//Personne personne = new Personne(1,"qsq","qdq");
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
	}
	

}
