package org.persistence;

import jakarta.persistence.*;

@Entity
@Table(name="practitioner")
@NamedStoredProcedureQuery(
        name = "Doctor.getDepartmentDoctors",
        procedureName = "get_department_doctors",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_dept", type = String.class)
        },
        resultClasses = Doctor.class
)
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private int doctorId;
    @Column(name="emp_name")
    private String doctorName;
    @Column(name="emp_department")
    private String department;
    @Column(name="emp_exp")
    private int experience;

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", department='" + department + '\'' +
                ", experience=" + experience +
                '}'+"\n";
    }

    public Doctor(int doctorId, String doctorName, String department, int experience) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.department = department;
        this.experience = experience;
    }

    public Doctor() {
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
