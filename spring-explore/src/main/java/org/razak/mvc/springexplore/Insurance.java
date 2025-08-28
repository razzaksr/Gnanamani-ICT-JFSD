package org.razak.mvc.springexplore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int insuranceId;
    private String schemeName;
    private String schemeType;
    private double maturityAmount;
    private int duration;
    private int premium;

    public Insurance() {
    }

    public Insurance(String schemeName, String schemeType, double maturityAmount, int duration, int premium) {
        this.schemeName = schemeName;
        this.schemeType = schemeType;
        this.maturityAmount = maturityAmount;
        this.duration = duration;
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "insuranceId=" + insuranceId +
                ", schemeName='" + schemeName + '\'' +
                ", schemeType='" + schemeType + '\'' +
                ", maturityAmount=" + maturityAmount +
                ", duration=" + duration +
                ", premium=" + premium +
                '}';
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }

    public double getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(double maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }
}
