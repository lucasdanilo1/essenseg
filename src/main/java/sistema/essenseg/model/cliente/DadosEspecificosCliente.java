package sistema.essenseg.model.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistema.essenseg.dto.cliente.DadosCadastroClienteDTO;

@Embeddable
@Getter
@NoArgsConstructor
public class DadosEspecificosCliente {

    @Column(unique = true)
    private String cpf;

    private String nomeResponsavel;

    @Column(unique = true)
    private String cpfResponsavel;

    public DadosEspecificosCliente(DadosCadastroClienteDTO dados){
        this.cpf = dados.dadosEspecificosCadastroClienteDTO().cpf();
        this.nomeResponsavel = dados.dadosEspecificosCadastroClienteDTO().nomeResponsavel();
        this.cpfResponsavel = dados.dadosEspecificosCadastroClienteDTO().cpfResponsavel();
    }
}
