package ProyectHealthRest.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> specialty;
    @Column
    private String name;
    @Column
    private String lastName;
    @ElementCollection
    List<Patients>patients;

    @Column
    private Double consultationPrice;
    @OneToOne
    private File file;
    @OneToOne
    private Image image;

    public Professional() {
    }

    public Professional(Long id, List<String> specialty, String name, String lastName, List<Patients> patients, Double consultationPrice,File file, Image image) {
        this.id = id;
        this.specialty = specialty;
        this.name = name;
        this.lastName = lastName;
        this.patients = patients;
        this.consultationPrice = consultationPrice;
        this.image=image;
        this.file=file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<String> specialty) {
        this.specialty = specialty;
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

    public List<Patients> getPatients() {
        return patients;
    }

    public void setPatients(List<Patients> patients) {
        this.patients = patients;
    }

    public Double getConsultationPrice() {
        return consultationPrice;
    }

    public void setConsultationPrice(Double consultationPrice) {
        this.consultationPrice = consultationPrice;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
