package ProyectHealthRest.Entities;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Calendar iShift;
    @Column
    private Calendar finishShift;
    @OneToOne
    private Comment comment;
    @OneToOne
    private Patients patient;
    @OneToOne
    private Professional professional;

    public Shift() {
    }

    public Shift(Long id, Calendar iShift, Calendar finishShift, Comment comment, Patients patient, Professional professional) {
        this.id = id;
        this.iShift = iShift;
        this.finishShift = finishShift;
        this.comment = comment;
        this.patient = patient;
        this.professional = professional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getiShift() {
        return iShift;
    }

    public void setiShift(Calendar iShift) {
        this.iShift = iShift;
    }

    public Calendar getFinishShift() {
        return finishShift;
    }

    public void setFinishShift(Calendar finishShift) {
        this.finishShift = finishShift;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}