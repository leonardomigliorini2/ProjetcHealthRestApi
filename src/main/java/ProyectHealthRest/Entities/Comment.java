package ProyectHealthRest.Entities;

import jakarta.persistence.*;



@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @OneToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    public Comment() {
    }

    public Comment(Long id, String description, Note note) {
        this.id = id;
        this.description = description;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
