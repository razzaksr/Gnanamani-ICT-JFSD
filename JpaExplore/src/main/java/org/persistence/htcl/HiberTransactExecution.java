package org.persistence.htcl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.persistence.Doctor;

public class HiberTransactExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) factory;
        EventListenerRegistry registry = sessionFactoryImpl.getServiceRegistry()
                .getService(EventListenerRegistry.class);
        Session session = factory.openSession();
        TransactionListeners transactionListeners = new TransactionListeners();
        registry.appendListeners(EventType.POST_INSERT, transactionListeners);
        registry.appendListeners(EventType.POST_UPDATE, transactionListeners);
        registry.appendListeners(EventType.POST_DELETE, transactionListeners);
        Transaction tx = session.getTransaction();

        // Hibernate Transaction Control
        try{
            tx.begin();
            // create row/ insertion
            Doctor doctor1 = new Doctor("Anand","Psychology",10);
            session.persist(doctor1);

            // read and update
            Doctor exists = session.find(Doctor.class,6);
//            exists.setDepartment("Radiology");
            exists.setExperience(8);

            Doctor toBeDeleted = session.find(Doctor.class,4);
            session.remove(toBeDeleted);

            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
            System.out.println("Transactions Failed");
        }

        session.close();

    }
}
