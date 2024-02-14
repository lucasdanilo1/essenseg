package sistema.essenseg.model.cliente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.cliente.AtualizaDadosClienteDTO;
import sistema.essenseg.dto.cliente.DadosCadastroClienteDTO;
import sistema.essenseg.model.segurado.DadosContratacaoSegurado;
import sistema.essenseg.model.segurado.DadosPessoaisSegurado;
import sistema.essenseg.model.segurado.Segurado;

@Getter
@Setter
@Entity
@NoArgsConstructor
@DiscriminatorValue("cliente")
public class Cliente extends Segurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Cliente(DadosCadastroClienteDTO dados){
       this.dadosPessoaisSegurado = new DadosPessoaisSegurado(dados);
       this.dadosEspecificosCliente = new DadosEspecificosCliente(dados);
       this.dadosContratacaoSegurado = new DadosContratacaoSegurado(dados);
       this.observacoes = dados.observacoes();
    }

    public void atualizarInformacoes(AtualizaDadosClienteDTO dados){
        if(dados != null){
            if(dados.atualizaDadosSeguradoDTO() != null){
                this.dadosPessoaisSegurado.checaCamposEAtualiza(dados.atualizaDadosSeguradoDTO());
                this.dadosContratacaoSegurado.checaCamposEAtualiza(dados.atualizaDadosSeguradoDTO());
            }
            if(dados.observacoes() != null){
                if(!dados.observacoes().isEmpty()){
                    this.observacoes = dados.observacoes();
                }
            }
        }
    }

    public Long getId() {
        return super.id;
    }
}