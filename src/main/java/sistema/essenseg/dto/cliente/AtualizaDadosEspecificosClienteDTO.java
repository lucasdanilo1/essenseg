package sistema.essenseg.dto.cliente;

import java.math.BigDecimal;

public record AtualizaDadosEspecificosClienteDTO(

        String nomeResponsavel,

        BigDecimal peso,

        BigDecimal altura
) {
}
