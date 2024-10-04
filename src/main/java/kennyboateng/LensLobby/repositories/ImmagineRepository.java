package kennyboateng.LensLobby.repositories;

import kennyboateng.LensLobby.entities.Immagine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmagineRepository extends JpaRepository<Immagine, Long> {
}
