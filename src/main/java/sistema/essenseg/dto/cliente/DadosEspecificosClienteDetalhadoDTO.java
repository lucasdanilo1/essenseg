package sistema.essenseg.dto.cliente;

import sistema.essenseg.model.cliente.DadosEspecificosCliente;

public record DadosEspecificosClienteDetalhadoDTO(

       String cpf,

       String nomeResponsavel,

       String cpfResponsavel

) {
    public DadosEspecificosClienteDetalhadoDTO(DadosEspecificosCliente dados){
        this(dados.getCpf(), dados.getNomeResponsavel(), dados.getCpfResponsavel());
    }
}
