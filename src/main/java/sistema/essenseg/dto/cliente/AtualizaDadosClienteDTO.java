package sistema.essenseg.dto.cliente;

import sistema.essenseg.dto.segurado.AtualizaDadosSeguradoDTO;

public record AtualizaDadosClienteDTO(

        AtualizaDadosSeguradoDTO atualizaDadosSeguradoDTO,

        String observacoes

) {
}
