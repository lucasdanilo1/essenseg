package sistema.essenseg.dto.empresa;


import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record DadosEspecificosCadastroEmpresaDTO(

        String razaoSocial,

        String nomeFantasia,

        @CNPJ
        @NotBlank
        String cnpj,

        String atvEconomica,

        String dataAbertura

) {
}