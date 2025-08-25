package org.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceCRUDExecution {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("doc");
        EntityManager em = emf.createEntityManager();

        // transient State
        Doctor doctor = new Doctor();
        doctor.setDoctorName("Abinesh");
        doctor.setDepartment("Psychology");
        doctor.setExperience(4);

        // Transaction begin
        em.getTransaction().begin();

        // Create/ Insert
        // persist State
//        em.persist(doctor);

        // Read
//        Doctor exists = em.find(Doctor.class,1);
//        System.out.println(exists);

        // Update State
//        exists.setExperience(9);

        // Read
//        Doctor exists = em.find(Doctor.class,2);
//        System.out.println(exists);
//
//        // Delete/ Remove State
//        em.remove(exists);

        // Read
        Doctor exists = em.find(Doctor.class,3);
        System.out.println(exists);

        // Transaction end for commit
        em.getTransaction().commit();

        // detach State
        // exists.setExperience(6);

        em.close();
    }
}
