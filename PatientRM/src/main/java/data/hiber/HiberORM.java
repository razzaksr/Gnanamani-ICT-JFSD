package data.hiber;

import data.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HiberORM {
    private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
    public void createPatient(Patient patient){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.persist(patient);
        session.getTransaction().commit();
        session.close();
    }
    public List<Patient> getPatients() throws Exception {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        List<Patient> patients=session.createQuery("from Patient").getResultList();
        session.getTransaction().commit();
        session.close();
        return patients;
    }
    public void update(Patient patient) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Patient exists = session.find(Patient.class,patient.getPatientId());
        exists.setPatientName(patient.getPatientName());
        exists.setQrCode(patient.getQrCode());
        exists.setHeight(patient.getHeight());
        exists.setWeight(patient.getWeight());
        exists.setAge(patient.getAge());
        exists.setContact(patient.getContact());

        session.getTransaction().commit();
        session.close();
    }
    public void  deletePatient(int patientId) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Patient exists = session.find(Patient.class,patientId);
        session.remove(exists);

        session.getTransaction().commit();
        session.close();
    }
}
