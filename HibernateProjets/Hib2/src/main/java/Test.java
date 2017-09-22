import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Adresse;
import model.Personne;
import model.Rib;

public class Test {

	public static void main(String[] args) {
		test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		//test7();
		//test8();
		
	}
	
	
	static void testmerge2() { 
		/*
		 * Ici merge est utilise pour persisiter un objet : si l'objet existe
		 * il ne fai rien sinon l'objet est envoyé dans la base
		 * 
		 */
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
			/*
			 * on objet qui est sortit du contxte de persistence 
			 * en l'occurrence p1 apres le commit(); on le peut tjs le remettre 
			 * dans le context de persistence ( l'objet a toujours son N° de version 
			 * on recopie cette instance et fait un merge
			 * 
			 */
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

		p2=em.merge(p1); // on recupere p1 via p2 et c'est p2 qui est dans le contexte  de persistence
		tx.commit();
		em.close();
		}
	
	
	
	static void test8() { // pour select *
		String choix="toto";
		List<Personne> al = selectByName(choix);
		for(Personne x : al) {
			System.out.println(x);
		}
		
	}
	
	static List<Personne> selectByName(String nom){ // pour select par nom
		final String QUERY = "SELECT p FROM Personne p "
				+ "WHERE p.nom = :nom " ;
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		
				Query query = em.createQuery(QUERY) ;
				query.setParameter("nom", nom);
				
				List<Personne> list = query.getResultList();
				em.close();
		return list;
	}
	
	
	
static void test7() { // pour select *
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		final String QUERY = "SELECT p.nom FROM Personne p";	
		Query query = em.createQuery( QUERY ) ;
		//--- Execute query
		System.out.println("execute query ...");
		List<String> list = query.getResultList() ;
		System.out.println("Number of personnes : " + list.size() );
		for ( String nom : list ) {
		System.out.println( nom );
		}
		em.close();
		
		
	}
	
	
	static void test6() { // pour select *
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		final String QUERY = "SELECT p FROM Personne p";	
		Query query = em.createQuery( QUERY ) ;
		//--- Execute query
		System.out.println("execute query ...");
		List<Personne> list = query.getResultList() ;
		System.out.println("Number of personnes : " + list.size() );
		for ( Personne p : list ) {
		System.out.println( p );
		}
		em.close();
		
		
	}
	
	static void test5() { // pour modifier
		Personne p1 = null;
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		p1 = em.find(Personne.class,1);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p1.setNom("toto");
		p1.setPrenom("titi");
		tx.commit();
		em.close();	
		
	}

	
	
	static void test4() { // pour remover on passe par un find()
		
		Personne p1 = null;
		
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		p1 = em.find(Personne.class,1);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(p1);
		tx.commit();
		em.close();	
}	
	
	
static void test3() { // pour insererr des ligne version 2
		
		Personne p1 = new Personne(3,"er","tert", new Rib("0215","78563"));
		
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p1.setNom("xx");
		em.persist(p1);
		p1.setNom("xxx");
		p1.setNom("xxxx");
		tx.commit();
		p1.setNom("xxxxx");// cette op apres le commite n'est pas pris e compte
			
			em.close();
			
			System.out.println(p1);
		
	}
	
	
	
	static void test2() { // pour insererr des ligne
		
		Personne p1 = null;
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
			p1 = em.find(Personne.class,1);
			em.close();
			
			System.out.println(p1);
		
	}
	
	
	static void test1() { // pour insererr des ligne
		
		//System.out.println("je suis mavenConsoleHib2");
		Rib r1 = new Rib("2154","urukmkm");
		Rib r2 = new Rib("6541","adcd");
		Adresse a1 = new Adresse("rue garonne",45, 75012);
		Adresse a2 = new Adresse("rue Balzac",6, 75017);
		Personne p1 = new Personne(1,"qsq","qdq",r1);
		Personne p2 = new Personne(2,"ssd","444",r2);
		
//		Personne p3 = new Personne(10,"toto","clash", new Rib("4568","7895"));
//		Personne p4 = new Personne(12,"toto","bingo", new Rib("6598","1259"));
		
		EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("formation-jpa");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		
		p1.setRib(r1);
		p2.setRib(r2);
		//em.persist(p1);
		//em.persist(p2);
//		em.persist(p3);
//		em.persist(p4);
		tx.commit();
		em.close();
		
	}
	

}
