package org.persistence.embedscollect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbedExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Subject subject1 = new Subject();
        subject1.setSubjectId(87678);
        subject1.setSubjectName("OS");
        subject1.setYear(3);
        Subject subject2 = new Subject();
        subject2.setSubjectId(1111);
        subject2.setSubjectName("Cyber");
        subject2.setYear(4);
        Professor professor = new Professor("Ashish",876567876L,subject1,subject2);

        session.persist(professor);

        session.getTransaction().commit();
        session.close();

    }
}
