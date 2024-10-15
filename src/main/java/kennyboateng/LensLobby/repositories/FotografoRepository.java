package kennyboateng.LensLobby.repositories;

import kennyboateng.LensLobby.entities.Fotografo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FotografoRepository extends JpaRepository<Fotografo, Long> {

    Optional<Fotografo> findByEmail(String email);
}
