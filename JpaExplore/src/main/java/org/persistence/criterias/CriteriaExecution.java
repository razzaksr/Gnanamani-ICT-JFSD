package org.persistence.criterias;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.persistence.Doctor;

import java.util.List;

public class CriteriaExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.getTransaction();

        // Criteria Setup
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Doctor> criteriaQuery = builder.createQuery(Doctor.class);
        Root<Doctor> root = criteriaQuery.from(Doctor.class);

        tx.begin();

        // Read All
//        session.createQuery(criteriaQuery).list().forEach(System.out::println);
        // Read All who matches the given range of experience
//        List<Doctor> filtered = session.createQuery(criteriaQuery.where(builder.between(root.get("experience"),6,10))).getResultList();
//        filtered.forEach(System.out::println);
        // Read All belong to the specific department
//        session.createQuery(criteriaQuery.where(builder.equal(root.get("department"),"Physio"))).list().forEach(System.out::println);
        // Read All those who are belong to or
//        session.createQuery(
//                criteriaQuery.where(
//                        builder.or(
//                                builder.equal(root.get("department"),"Cardio"),
//                                builder.equal(root.get("department"),"Radiology")
//                        )
//                )
//        ).getResultList().forEach(System.out::println);

        // Read All by starts with specified letter in doctors name
//        session.createQuery(
//                criteriaQuery.where(
//                        builder.like(root.get("doctorName"),"A%")
//                )
//        ).list().forEach(System.out::println);
        // Read All by ends with specified letter in doctors name
        TypedQuery query = session.createQuery(
                criteriaQuery.where(
                        builder.like(root.get("doctorName"),"%h")
                )
        );
        List<Doctor> shortListed = query.getResultList();
        for(Doctor temp:shortListed){
            System.out.println(temp);
        }

        tx.commit();
        session.close();
    }
}
