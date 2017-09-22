package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Patient;


public class TestPatient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m1();

	}

	static void m2() {
		
	}
	
	
	static void m1() {// inserer des lignes dans la tble Patient
		
			Patient p1 = new Patient(10, "Tali", "Bond");
			Patient p2 = new Patient(11, "Bon", "Pied");
			Patient p3 = new Patient(12, "OEIL", "Bonne");

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");

			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			
			tx.commit();
			em.close();
									
	}
	
	
	
	
	
}
