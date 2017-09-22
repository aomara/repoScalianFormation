import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Personne;
import model.Rib;

public class Test2 {

	public static void main(String[] args) {
		 m1();

	}
	static void m1() {
		
Rib r1 = new Rib("2154","adcd");
				
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		em.persist(r1);		
		tx.commit();
		em.close();	
	}
	
	static void m2() {
		
		Rib r1 = new Rib("2154","adcd");
						
				EntityManagerFactory emf = 
						Persistence.createEntityManagerFactory("formation-jpa");
				EntityManager em = emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				tx.begin();		
				em.persist(r1);		
				tx.commit();
				em.close();	
			}
	
	
	
}
