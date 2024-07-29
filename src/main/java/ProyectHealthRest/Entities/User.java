package ProyectHealthRest.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String contact;
    @Column
    private String address; //telefono
    @ElementCollection
    private List<Comment>coments;
    @OneToOne
    private Image image;

    public User() {
    }

    public User(Long id, String userName, String email, String password, String contact, String address, List<Comment> coments, Image image) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.address = address;
        this.coments = coments;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Comment> getComents() {
        return coments;
    }

    public void setComents(List<Comment> coments) {
        this.coments = coments;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
