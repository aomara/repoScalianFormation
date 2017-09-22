package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Patient;


public class DaoPatientH implements DaoPatient {
	
	
	public void create(Patient obj) {
		Patient p1 = new Patient();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p1.setNom("xx");
		p1.setPrenom("xxx");
		em.persist(p1);
		tx.commit();
		em.close();
		return ;

	}
	
	public List<Patient> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();

		String str = "SELECT p.nom FROM Patient p ";
		Query query = em.createQuery(str);
		// --- Execute query
		System.out.println("execute query ...");
		List<Patient> list = (List<Patient>)query.getResultList();
		System.out.println("Number of Patients : " + list.size());
//		for (Patient x : list) {
//			System.out.println(x);
//		}
			
		em.close();
		
		return list;
	}

	  List<Patient> selectByName(String nom) {
		final String QUERY = "SELECT p FROM Patient p "
				+ "WHERE p.nom = :nom " ;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
		EntityManager em = emf.createEntityManager();
				Query query = em.createQuery( QUERY ) ;
				query.setParameter("nom", nom);
				List<Patient> list = query.getResultList();
				em.close();
		return list;
	}
	
	// supprimer
	
		public void delete(Patient patient)// supprimer
		{
			Patient p1 = null;
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
			EntityManager em = emf.createEntityManager();
			//p1 = em.find(Patient.class, 1);			
			p1 = em.find(Patient.class, patient.getId());
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(p1);
			tx.commit();
			em.close();
		}
	
		@Override
		public Patient findById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void update(Patient obj) {
			// TODO Auto-generated method stub
			
		}

}
