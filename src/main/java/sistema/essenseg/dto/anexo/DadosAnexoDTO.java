package sistema.essenseg.dto.anexo;

import sistema.essenseg.model.Anexo;

public record DadosAnexoDTO(

        Long id,
        String nomeArquivo,
        String tipoArquivo,
        Long seguradoId

) {

    public DadosAnexoDTO(Anexo anexo){
        this(anexo.getId(),
                anexo.getNomeArquivo(),
                anexo.getTipoArquivo(),
                anexo.getSegurado().getId());
    }

}
