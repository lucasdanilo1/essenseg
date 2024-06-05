package sistema.essenseg.dto.operadora;

import jakarta.validation.constraints.NotBlank;
import sistema.essenseg.model.Operadora;

public record DadosOperadoraDTO(

        Long id,
        @NotBlank
        String nome

) {
        public DadosOperadoraDTO(Operadora operadora){
                this(operadora.getId(), operadora.getNome());
        }
}
