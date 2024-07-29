package ProyectHealthRest.Entities;


import jakarta.persistence.*;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String  Type;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private Byte contentType;

    public File() {
    }

    public File(Long id, String name, String type, Byte contentType) {
        this.id = id;
        this.name = name;
        this.Type = type;
        this.contentType = contentType;
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public Byte getContent(byte[] bytes) {
        return contentType;
    }

    public void setContent(byte[] content) {
        this.contentType = contentType;
    }
}
