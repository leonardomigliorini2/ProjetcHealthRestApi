package ProyectHealthRest.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String clinicHistory;
    @Column
    private String healthInsurance;

    @OneToOne
    private Image imagen;
    @Column
    private String email;
    @Column
    private Integer numberPhone;
    @Column
    private String Address;
    @ElementCollection
    private List<Comment>comments;
    @OneToOne
    private Note note;

    public Patients() {

    }

    public Patients(Long id, String name, String lastName, String clinicHistory, String healthInsurance, Image imagen, Integer numberPhone, String email, String address, List<Comment> comments, Note note) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.clinicHistory = clinicHistory;
        this.healthInsurance = healthInsurance;
        this.imagen = imagen;
        this.numberPhone = numberPhone;
        this.email = email;
        this.Address = address;
        this.comments=comments;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClinicHistory() {
        return clinicHistory;
    }

    public void setClinicHistory(String clinicHistory) {
        this.clinicHistory = clinicHistory;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }


    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(Integer numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
