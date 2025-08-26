package org.persistence.embedscollect;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lecturerId;
    private String lecturerName;
    private long lecturerContact;
    @ElementCollection
    @JoinTable(name="staff_mapping")
    private List<Subject> subjects=new ArrayList<>();
    public Lecturer() {}
    public Lecturer(String lecturerName, long lecturerContact, List<Subject> subjects) {
        this.lecturerName = lecturerName;
        this.lecturerContact = lecturerContact;
        this.subjects = subjects;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public long getLecturerContact() {
        return lecturerContact;
    }

    public void setLecturerContact(long lecturerContact) {
        this.lecturerContact = lecturerContact;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
