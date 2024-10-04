package kennyboateng.LensLobby.services;

import kennyboateng.LensLobby.entities.Immagine;
import kennyboateng.LensLobby.repositories.ImmagineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ImmagineService {

    @Autowired
    private ImmagineRepository immagineRepository;

    public Immagine saveImmagine(Immagine immagine) {
        return immagineRepository.save(immagine);
    }

    public List<Immagine> findAllImmagini() {
        return immagineRepository.findAll();
    }

    public Optional<Immagine> findImmagineById(Long id) {
        return immagineRepository.findById(id);
    }

    public void deleteImmagine(Long id) {
        immagineRepository.deleteById(id);
    }
}
