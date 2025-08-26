package org.persistence.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.stream.Stream;

public class InheritanceExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Drive drive = new Drive();
        drive.setEmail("deva@gmail.com");
        drive.setFreeSpace(10);
        drive.setTotalSpace(15);
        drive.setFullName("Deva Java");

        YouTube youTube = new YouTube();
        youTube.setFullName("Abinesh");
        youTube.setEmail("abinesh@gmail.com");
        youTube.setPlayList(Stream.of("sad","vibe",",motivational").toList());

        session.persist(drive);
        session.persist(youTube);

        session.getTransaction().commit();
        session.close();
    }
}
