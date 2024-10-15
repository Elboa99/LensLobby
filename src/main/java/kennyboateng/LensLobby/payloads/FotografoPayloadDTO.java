package kennyboateng.LensLobby.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public record FotografoPayloadDTO(
        @NotEmpty(message = "Devi inserire uno username")
        @Size(min = 3, max = 20, message = "Lo username deve avere dai 3 ai 20 caratteri")
        String nomeUtente,

        @NotEmpty(message = "Devi inserire una email")
        @Email(message = "Devi inserire una email valida")
        String email,

        @NotEmpty(message = "Devi inserire una password")
        @Size(min = 8, message = "La password deve avere almeno 8 caratteri")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "La password deve contenere almeno un numero, una lettera maiuscola, una minuscola e un carattere speciale.")
        String password,

        @NotEmpty(message = "Devi inserire un nome")
        @Size(min = 3, max = 20, message = "Il nome deve avere dai 3 ai 20 caratteri")
        String nome,

        @NotEmpty(message = "Devi inserire un cognome")
        @Size(min = 3, max = 40, message = "Il cognome deve avere dai 3 ai 40 caratteri")
        String cognome,

        String biografia
) {
}
