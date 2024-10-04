package kennyboateng.LensLobby.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString


@Table(name = "fotografi")
public class Fotografo {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String biografia;
    @OneToMany(mappedBy = "fotografo")
    private List<Immagine> immagini;

}
