package sistema.essenseg.dto.empresa;

import java.time.LocalDate;

public record FiltrosEmpresaDTO(

        String filtroGlobal,
        Long administradoraId,
        Long operadoraId,
        LocalDate primeiraDataVigencia,
        LocalDate segundaDataVigencia


) {

}
