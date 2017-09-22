import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Adresse;
import model.Dept;
import model.Personne;
import model.Rib;

public class Test4 {

	public static void main(String[] args) {
		m3();

	}
	
	static void m3() {
		Personne p1 = new Personne(301, "a", "b");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(p1);

		tx.commit();

		em.close();
	}

	static void m2() {

		Dept d = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");

		EntityManager em = emf.createEntityManager();
		d = em.find(Dept.class, 78);
		System.out.println(d.getLst().toString());
		em.close();

	}

	static void m1() {

		Dept d1 = new Dept(78, "abcd");

		Personne p1 = new Personne(105, "a", "b");
		Adresse a1 = new Adresse("rougemont", 6, 75009);
		// Rib r1 = new Rib("1234", "abcd");
		p1.setAdr(a1);
		// p1.setRib(r1);

		Personne p2 = new Personne(106, "a", "b");
		Adresse a2 = new Adresse("rougemont", 7, 75009);
		// Rib r2 = new Rib("456", "abcd");
		p2.setAdr(a2);
		// p2.setRib(r2);

		p1.setDepartment(d1);
		p2.setDepartment(d1);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(p1);

		em.persist(p2);

		em.persist(d1);

		tx.commit();

		em.close();
	}

}
