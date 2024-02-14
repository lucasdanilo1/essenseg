package sistema.essenseg.dto.segurado;

import lombok.Getter;
import lombok.Setter;
import sistema.essenseg.model.segurado.Segmentacao;
import sistema.essenseg.model.segurado.Segurado;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.model.empresa.Empresa;

import java.time.LocalDate;

@Getter
@Setter
public class DadosListagemSegurado {

    String tipo;
    Long id;
    LocalDate dataCadastro;
    String nome;
    String telefone;
    String email;
    String cpfCnpj;
    Segmentacao segmentacao;

    public DadosListagemSegurado(Segurado segurado){
        this.id = segurado.getId();
        this.telefone = segurado.getDadosPessoaisSegurado().getTelefone();
        this.dataCadastro = segurado.getDataDoCadastro();
        this.email = segurado.getDadosPessoaisSegurado().getEmail();
        this.segmentacao = segurado.getDadosContratacaoSegurado().getSegmentacao();
        if(segurado instanceof Cliente){
            this.tipo = "cliente";
            this.nome = segurado.getDadosPessoaisSegurado().getNome();
            this.cpfCnpj = segurado.getDadosEspecificosCliente().getCpf();
        } else if (segurado instanceof Empresa) {
            this.tipo = "empresa";
            this.nome = segurado.getDadosEspecificosEmpresa().getNomeFantasia();
            this.cpfCnpj = segurado.getDadosEspecificosEmpresa().getCnpj();
        }
    }
}
