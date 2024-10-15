package kennyboateng.LensLobby.controllers;

import kennyboateng.LensLobby.entities.Fotografo;
import kennyboateng.LensLobby.enums.Role;
import kennyboateng.LensLobby.exceptions.BadRequestException;
import kennyboateng.LensLobby.payloads.FotografoLoginDTO;
import kennyboateng.LensLobby.payloads.FotografoLoginResponseDTO;
import kennyboateng.LensLobby.payloads.FotografoPayloadDTO;
import kennyboateng.LensLobby.services.AuthorizationService;
import kennyboateng.LensLobby.services.FotografoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private FotografoService fotografoService;

    @PostMapping("/login")
    public FotografoLoginResponseDTO login(@RequestBody @Validated FotografoLoginDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            String errors = validationResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Errore di validazione: " + errors);
        }

        String token = authorizationService.checkCredentialsAndGenerateToken(body);
        Fotografo found = fotografoService.findByEmail(body.email())
                .orElseThrow(() -> new BadRequestException("Utente non trovato."));
        return new FotografoLoginResponseDTO(token, found.getRuolo(), found.getId());
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public FotografoLoginResponseDTO register(@RequestBody @Validated FotografoPayloadDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            String errors = validationResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Errore di validazione: " + errors);
        }

        Fotografo newFotografo = fotografoService.registerFotografo(body);
        String token = authorizationService.generateToken(newFotografo);
        return new FotografoLoginResponseDTO(token, newFotografo.getRuolo(), newFotografo.getId());
    }
}
