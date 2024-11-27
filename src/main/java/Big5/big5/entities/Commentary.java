package Big5.big5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "commentaries")
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @OneToOne(mappedBy = "commentary")
    private Evaluation evaluation;

    public Commentary(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }
}