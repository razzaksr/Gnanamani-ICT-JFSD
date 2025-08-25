package org.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class PersistenceQueryExecution {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("doc");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Read All Doctors via Jakarta Persistence Query Language
//        Query query = (Query) em.createQuery("from Doctor", Doctor.class);
//        List<Doctor> doctors = query.getResultList();
//        System.out.println(doctors);

        // Read All Doctor's name via JPQL
//        Query query = (Query) em.createQuery("select doctorName from Doctor", String.class);
//        List<String> doctors = query.getResultList();
//        System.out.println(doctors);

        // Read All Doctor's name via SQL, table names and column names
//        Query query = (Query) em.createNativeQuery("select emp_name from practitioner", String.class);
//        List<String> doctors = query.getResultList();
//        System.out.println(doctors);

        // Read All Doctor's name and experience via JPQL
//        Query query = (Query) em.createQuery("select doctorName,experience from Doctor", Object[].class);
//        List<Object[]> pairs = query.getResultList();
//        for (Object[] pair : pairs) {
//            System.out.println(Arrays.toString(pair));
//        }

        // Read specific rows
        Query query = (Query) em.createQuery("from Doctor where experience between :start and :end", Doctor.class);
        query.setParameter("start", 8);
        query.setParameter("end", 15);
        List<Doctor> doctors = query.getResultList();
        System.out.println(doctors);

        em.getTransaction().commit();
        em.close();
    }
}
