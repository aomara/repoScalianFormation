import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Personne;

public class Test {

	public static void main(String[] args) {

		test7();
	}

	static void test8() {// select *
		String choix = "toto";
		List<Personne> al = selectByName(choix);
		for (Personne x : al) {
			System.out.println(x);
		}
	}

	static List<Personne> selectByName(String nom) {//select par le nom
		final String QUERY = "SELECT p FROM Personne p "
				+ "WHERE p.nom = :nom " ;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
				Query query = em.createQuery( QUERY ) ;
				//---- Set parameters
				query.setParameter("nom", nom);
				//--- Execute query
				List<Personne> list = query.getResultList();
				em.close();
		return list;
	}

	static void test7() {// select *
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();

		String str = "SELECT p.nom FROM Personne p ";
		Query query = em.createQuery(str);
		// --- Execute query
		System.out.println("execute query ...");
		List<String> list = query.getResultList();
		System.out.println("Number of personnes : " + list.size());
		for (String x : list) {
			System.out.println(x);
		}
		em.close();
	}

	static void test6() {// 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();

		String str = "SELECT p FROM Personne p ";
		Query query = em.createQuery(str);
		// --- Execute query
		System.out.println("execute query ...");
		List<Personne> list = query.getResultList();
		System.out.println("Number of personnes : " + list.size());
		for (Personne x : list) {
			System.out.println(x);
		}
		em.close();
	}

	static void test5()// modifier
	{
		Personne p1 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");

		EntityManager em = emf.createEntityManager();
		p1 = em.find(Personne.class, 2);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p1.setNom("3c");
		tx.commit();
		em.close();

	}

	static void test4()// supprimer
	{
		Personne p1 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");

		EntityManager em = emf.createEntityManager();
		p1 = em.find(Personne.class, 1);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(p1);
		tx.commit();
		em.close();
	}

	static void test3()// inserer des lignes v2
	{
		Personne p1 = new Personne(6, "x", "y");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p1.setNom("xx");
		em.persist(p1);
		p1.setNom("xxx");
		p1.setNom("xxxx");
		tx.commit();
		p1.setNom("5x");
		em.close();

	}

	static void test2()// select dune ligne
	{
		Personne p1 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");

		EntityManager em = emf.createEntityManager();
		p1 = em.find(Personne.class, 1);

		em.close();
		System.out.println(p1);

	}

	static void test1()// inserer des lignes
	{
		Personne p1 = new Personne(10, "toto", "x");
		Personne p2 = new Personne(11, "toto", "y");
		Personne p3 = new Personne(12, "toto", "z");

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
	
	static void testmerge2() {
		Personne p1 = new Personne();
		
		p1.setId(16);
		p1.setNom("a");
		p1.setPrenom("b");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");

		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(p1);
		
		tx.commit();
		em.close();
	}

	static void testmerge1() {
		Personne p1 = new Personne();
		System.out.println(p1.getVersion());
		Personne p2;
		p1.setId(17);
		p1.setNom("a");
		p1.setPrenom("b");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");

		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(p1);
		p1.setNom("x");
		tx.commit();
		em.close();
		System.out.println(p1.getVersion());//1
		p1.setPrenom("titi");
		// New extended persistence context
		 emf = Persistence.createEntityManagerFactory("formation-jpa");
		 em = emf.createEntityManager();
		 tx = em.getTransaction();
		tx.begin();

		p2=em.merge(p1);
		
		
		tx.commit();
		em.close();
	}

}
