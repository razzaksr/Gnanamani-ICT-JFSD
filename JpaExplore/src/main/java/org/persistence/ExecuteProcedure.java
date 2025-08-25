package org.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ExecuteProcedure {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("doc");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // procedure call
        List<Doctor> filtered = em.createNamedStoredProcedureQuery("Doctor.getDepartmentDoctors")
                .setParameter("p_dept", "Psychology")
                .getResultList();
        System.out.println(filtered);


        em.getTransaction().commit();
        em.close();
    }
}
