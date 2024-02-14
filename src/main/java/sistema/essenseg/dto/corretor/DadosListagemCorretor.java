package sistema.essenseg.dto.corretor;

import sistema.essenseg.model.Corretor;

public record DadosListagemCorretor(
        Long id,
        String nome,
        String email,
        String telefone
) {
   public DadosListagemCorretor(Corretor corretor){
       this(corretor.getId(),
               corretor.getNome(),
               corretor.getEmail(),
               corretor.getTelefone()
               );
   }
}
