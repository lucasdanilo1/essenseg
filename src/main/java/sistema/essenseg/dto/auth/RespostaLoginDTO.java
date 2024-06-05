package sistema.essenseg.dto.auth;

public record RespostaLoginDTO(
        String token,
        String nomeUsuario
) {
}
