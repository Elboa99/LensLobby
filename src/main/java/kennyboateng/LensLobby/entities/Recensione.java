package kennyboateng.LensLobby.entities;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "recensioni")
public class Recensione {
    @Id
    @GeneratedValue
    private  Long id;
    @Column
    private String testo;


    @ManyToOne
    @JoinColumn(name = "fotografo_id")
    private Fotografo fotografo;
}

