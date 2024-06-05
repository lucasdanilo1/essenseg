package sistema.essenseg.dto.cliente;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record DadosEspecificosCadastroClienteDTO(

        @NotNull
        String cpf,

        String nomeResponsavel,

        @CPF
        String cpfResponsavel,

        BigDecimal peso,

        BigDecimal altura

        ) {
}
