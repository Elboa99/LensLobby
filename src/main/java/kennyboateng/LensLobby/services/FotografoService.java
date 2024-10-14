package kennyboateng.LensLobby.services;

import kennyboateng.LensLobby.entities.Fotografo;
import kennyboateng.LensLobby.exceptions.UnauthorizedException;
import kennyboateng.LensLobby.repositories.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FotografoService {
    @Autowired
    private FotografoRepository fotografoRepository;

    public Fotografo saveFotografo(Fotografo fotografo) {
        return fotografoRepository.save(fotografo);
    }

    public List<Fotografo> findAllFotografi() {
        return fotografoRepository.findAll();
    }

    public Optional<Fotografo> findFotografoById(Long id) {
        return fotografoRepository.findById(id);
    }

    public Fotografo loadFotografoById(Long id) throws UnauthorizedException {
        return findFotografoById(id).orElseThrow(() -> new UnauthorizedException("Fotografo non trovato."));
    }


    public void deleteFotografo(Long id) {
        fotografoRepository.deleteById(id);
    }
}
