package sistema.essenseg.dto;

import sistema.essenseg.model.OperadoraAdministradora;

public record DadosListagemRelacoesDTO(

        Long relacaoId,
        String operadora,
        String administradora

) {

    public DadosListagemRelacoesDTO(OperadoraAdministradora operadoraAdministradora){
        this(operadoraAdministradora.getId(),
                operadoraAdministradora.getOperadora().getNome(),
                operadoraAdministradora.getAdministradora().getNome());
    }

}
