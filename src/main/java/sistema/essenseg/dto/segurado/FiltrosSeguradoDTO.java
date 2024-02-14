package sistema.essenseg.dto.segurado;

import java.time.LocalDate;

public record FiltrosSeguradoDTO(

        String filtroGlobal,
        String segmentacao,
        Long administradoraId,
        Long operadoraId,
        LocalDate dataVigencia1,
        LocalDate dataVigencia2,
        LocalDate dataNascimento1,
        LocalDate dataNascimento2

) {

}
