package org.persistence.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HibernateExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create new Bus along with Students
        Candidate candidate1 = new Candidate(620822243002L,"Abinesh","AInDS",9876545676L);
        Candidate candidate2 = new Candidate(620822243009L,"Anusha","AInDS",987656787656L);
        Candidate candidate3 = new Candidate(620822243123L,"Yesani","AInDS",98765678765L);
        Candidate candidate4 = new Candidate(620822243118L,"Vignesh","IT",6789876898789L);
        List<Candidate> students = Stream.of(candidate1,candidate2,candidate3,candidate4).collect(Collectors.toList());

        Bus bus = new Bus("tn30M9988",28,"Kenny",98765678833L);
        bus.setPassangers(students);

        candidate1.setBus(bus);
        candidate2.setBus(bus);
        candidate3.setBus(bus);
        candidate4.setBus(bus);

        session.persist(bus);


        tx.commit();
        session.close();
    }
}
