import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Adresse;
import model.Personne;
import model.Rib;

public class Test3 {

	public static void main(String[] args) {
		m1();

	}
	static void m1()
	{
		Adresse a1=new Adresse("rougemont", 6, 75009);
		Personne p1 = new Personne(200,"x200","y200");
		p1.setAdr(a1);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(p1);

		tx.commit();

		em.close();
	}

}
