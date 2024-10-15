package kennyboateng.LensLobby.payloads;

import kennyboateng.LensLobby.enums.Role;


public record FotografoLoginResponseDTO( String accessToken, Role role, Long fotografoId) {
}
