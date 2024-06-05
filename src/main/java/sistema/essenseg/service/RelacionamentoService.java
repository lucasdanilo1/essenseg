package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.DadosListagemRelacoesDTO;
import sistema.essenseg.dto.administradora.DadosListagemAdministradoraDTO;
import sistema.essenseg.dto.relacionamento.DadosRelacionamentoDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.model.OperadoraAdministradora;
import sistema.essenseg.repository.AdministradoraRepository;
import sistema.essenseg.repository.OperadoraRepository;
import sistema.essenseg.repository.OperadorasAdministradorasRepository;

import java.util.List;

@Service
public class RelacionamentoService {

    @Autowired
    OperadoraRepository operadoraRepository;
    @Autowired
    AdministradoraRepository administradoraRepository;
    @Autowired
    OperadorasAdministradorasRepository operadorasAdministradorasRepository;

    public ResponseEntity<?> relacionar(DadosRelacionamentoDTO dados){
        Administradora administradora = administradoraRepository.getReferenceById(dados.administradoraId());
        Operadora operadora = operadoraRepository.getReferenceById(dados.operadoraId());

        OperadoraAdministradora operadorasAdministradoras = new OperadoraAdministradora(administradora, operadora);

        operadorasAdministradorasRepository.save(operadorasAdministradoras);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<DadosListagemAdministradoraDTO>> listaAdministradoraPorOperadoraId(Long id){
        return ResponseEntity.ok().body(operadorasAdministradorasRepository.findAdministradorasByOperadoraId(id).stream().map(DadosListagemAdministradoraDTO::new).toList());
    }

    public ResponseEntity<List<DadosListagemRelacoesDTO>> listarRelacoes(){
        return ResponseEntity.ok().body(operadorasAdministradorasRepository.findAll().stream().map(DadosListagemRelacoesDTO::new).toList());
    }

    public ResponseEntity<List<DadosListagemAdministradoraDTO>> listaAdministradorasSemRelacaoComOperadora(Long id) {
        return ResponseEntity.ok().body(operadorasAdministradorasRepository.findAdministradoraSemRelacaoComOperadora(id).stream().map(DadosListagemAdministradoraDTO::new).toList());
    }
}
