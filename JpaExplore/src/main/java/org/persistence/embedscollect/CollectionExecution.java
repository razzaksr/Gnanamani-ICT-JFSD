package org.persistence.embedscollect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionExecution {
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
        List<Subject> subjects = Stream.of(subject1, subject2).collect(Collectors.toList());
        Lecturer lecturer = new Lecturer("Manikandan",8765456789876L,subjects);

        session.persist(lecturer);

        session.getTransaction().commit();
        session.close();

    }
}
