package kennyboateng.LensLobby.services;



import kennyboateng.LensLobby.entities.Fotografo;
import kennyboateng.LensLobby.exceptions.UnauthorizedException;
import kennyboateng.LensLobby.payloads.FotografoPayloadDTO;
import kennyboateng.LensLobby.repositories.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class FotografoService {
    @Autowired
    private FotografoRepository fotografoRepository;

    @Autowired
    private PasswordEncoder bcrypt;

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

    public Optional<Fotografo> findByEmail(String email) {
        return fotografoRepository.findByEmail(email);
    }

    public Fotografo registerFotografo(FotografoPayloadDTO fotografoDTO) {
        Fotografo newFotografo = new Fotografo();
        newFotografo.setNomeUtente(fotografoDTO.nomeUtente());
        newFotografo.setEmail(fotografoDTO.email());
        newFotografo.setNome(fotografoDTO.nome());
        newFotografo.setBiografia(fotografoDTO.biografia());
        // Codifica la password prima di salvarla


        newFotografo.setPassword(bcrypt.encode(fotografoDTO.password()));
        return fotografoRepository.save(newFotografo);
    }
}
