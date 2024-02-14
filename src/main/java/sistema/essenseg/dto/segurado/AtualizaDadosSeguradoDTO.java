package sistema.essenseg.dto.segurado;

import jakarta.validation.constraints.Email;
import sistema.essenseg.model.segurado.Segmentacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AtualizaDadosSeguradoDTO(

        Long operadoraId,

        Long administradoraId,

        Long planoId,

        LocalDate vigencia,

        BigDecimal valorDoPlano,

        BigDecimal percentualComissao,

        BigDecimal adesao,

        Segmentacao segmentacao,

        String nome,

        String telefone,

        String cep,

        String endereco,

        @Email
        String email

) {
}
