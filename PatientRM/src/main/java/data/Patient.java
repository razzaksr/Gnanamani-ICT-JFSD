package data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// bean class
@Entity
public class Patient {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int patientId;
    private String patientName;
    private double weight;
    private double height;
    private int age;
    private long contact;
    private String qrCode;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Patient(String patientName, double weight, double height, int age, long contact, String qrCode) {
        this.patientName = patientName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.contact = contact;
        this.qrCode = qrCode;
    }

    public Patient(int patientId, String patientName, double weight, double height, int age, long contact, String qrCode) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.contact = contact;
        this.qrCode = qrCode;
    }

    public Patient() {
    }
}
