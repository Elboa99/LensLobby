package kennyboateng.LensLobby.repositories;

import kennyboateng.LensLobby.entities.Fotografo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotografoRepository extends JpaRepository<Fotografo, Long> {
}
