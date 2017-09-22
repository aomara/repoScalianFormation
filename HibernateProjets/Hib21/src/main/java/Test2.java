import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Personne;
import model.Rib;

public class Test2 {

	public static void main(String[] args) {
		m3();

	}
	static void m3() {
		Personne p1 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");

		EntityManager em = emf.createEntityManager();
		p1 = em.find(Personne.class, 100);

		em.close();
		Rib r=p1.getRib();
		System.out.println(r);

	}
	static void m2() {
		Rib r2 = new Rib("12356", "abcd");
		Personne p2 = new Personne(100,"x","y");
		p2.setRib(r2);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(r2);
		em.persist(p2);
		

		tx.commit();

		em.close();

	}

	static void m1() {
		Rib r1 = new Rib("1234", "abcd");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(r1);

		tx.commit();

		em.close();

	}

}
