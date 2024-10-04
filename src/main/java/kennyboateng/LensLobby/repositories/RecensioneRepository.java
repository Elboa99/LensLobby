package kennyboateng.LensLobby.repositories;

import kennyboateng.LensLobby.entities.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
}
