package org.persistence.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Candidate {
    @Id
    private long regNo;
    private String name;
    private String department;
    private long contact;

    @ManyToOne
    private Bus bus;

    public Candidate() {
    }

    public Candidate(long regNo, String name, String department, long contact) {
        this.regNo = regNo;
        this.name = name;
        this.department = department;
        this.contact = contact;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public long getRegNo() {
        return regNo;
    }

    public void setRegNo(long regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }
}
