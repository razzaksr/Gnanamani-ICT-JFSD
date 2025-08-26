package org.persistence.embedscollect;

import jakarta.persistence.*;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;
    private String professorName;
    private long professorContact;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(column=@Column(name = "final_id"),name="subjectId"),
            @AttributeOverride(column=@Column(name = "final_paper"),name="subjectName"),
            @AttributeOverride(column=@Column(name = "final_year"),name="year")
    })
    private Subject finalYear;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(column=@Column(name = "pre_final_id"),name="subjectId"),
            @AttributeOverride(column=@Column(name = "pre_final_paper"),name="subjectName"),
            @AttributeOverride(column=@Column(name = "pre_final_year"),name="year")
    })
    private Subject preFinalYear;

    public Professor() {
    }

    public Professor(String professorName, long professorContact, Subject finalYear, Subject preFinalYear) {
        this.professorName = professorName;
        this.professorContact = professorContact;
        this.finalYear = finalYear;
        this.preFinalYear = preFinalYear;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "professorId=" + professorId +
                ", professorName='" + professorName + '\'' +
                ", professorContact=" + professorContact +
                ", finalYear=" + finalYear +
                ", preFinalYear=" + preFinalYear +
                '}';
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public long getProfessorContact() {
        return professorContact;
    }

    public void setProfessorContact(long professorContact) {
        this.professorContact = professorContact;
    }

    public Subject getFinalYear() {
        return finalYear;
    }

    public void setFinalYear(Subject finalYear) {
        this.finalYear = finalYear;
    }

    public Subject getPreFinalYear() {
        return preFinalYear;
    }

    public void setPreFinalYear(Subject preFinalYear) {
        this.preFinalYear = preFinalYear;
    }
}
