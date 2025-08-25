package org.persistence.hbm;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bus {
    @Column(unique = true)
    private String registrationNumber;
    @Id
    private int routeNo;
    private String driverName;
    private long driverContact;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Candidate> passangers = new ArrayList();

    public Bus() {
    }

    public Bus(String registrationNumber, int routeNo, String driverName, long driverContact) {
        this.registrationNumber = registrationNumber;
        this.routeNo = routeNo;
        this.driverName = driverName;
        this.driverContact = driverContact;
    }

    public List<Candidate> getPassangers() {
        return passangers;
    }

    public void setPassangers(List<Candidate> passangers) {
        this.passangers = passangers;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(int routeNo) {
        this.routeNo = routeNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public long getDriverContact() {
        return driverContact;
    }

    public void setDriverContact(long driverContact) {
        this.driverContact = driverContact;
    }
}
