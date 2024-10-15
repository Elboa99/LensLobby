package kennyboateng.LensLobby.services;

import kennyboateng.LensLobby.entities.Fotografo;
import kennyboateng.LensLobby.exceptions.UnauthorizedException;
import kennyboateng.LensLobby.payloads.FotografoLoginDTO;
import kennyboateng.LensLobby.repositories.FotografoRepository;
import kennyboateng.LensLobby.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    @Autowired
    private FotografoRepository fotografoRepository;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private PasswordEncoder bcrypt;

    public String checkCredentialsAndGenerateToken(FotografoLoginDTO body) {
        Fotografo found = fotografoRepository.findByEmail(body.email())
                .orElseThrow(() -> new UnauthorizedException("Credenziali non valide."));

        if (bcrypt.matches(body.password(), found.getPassword())) {
            return jwtTools.createToken(found);
        } else {
            throw new UnauthorizedException("Errore nelle credenziali che hai fornito");
        }
    }

    public String generateToken(Fotografo fotografo) {
        return jwtTools.createToken(fotografo);
    }
}
