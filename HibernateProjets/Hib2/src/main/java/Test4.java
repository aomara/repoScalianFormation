import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Dept;
import model.Personne;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
m1();
	}

	
	static void m1() {
		Dept d1 = new Dept(75, "idf");
		Dept d2 = new Dept(78, "azerf");
		
		Personne p1 = new Personne(101,"a","b");
		Personne p2 = new Personne(102,"d","e");
		//p1.
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
				
				EntityManager em = emf.createEntityManager();
				
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.persist(d1);
				tx.commit();
				em.close();
	}
}
