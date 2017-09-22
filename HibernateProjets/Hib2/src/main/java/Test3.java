import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Adresse;
import model.Personne;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void m1() {
		Adresse a1 = new Adresse("Rougemont", 6, 75009);
		Personne p1 = new Personne(200,"azerty", "querty");
		p1.setAdr(a1);
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		em.persist(p1);		
		tx.commit();
		em.close();	
	}
}
