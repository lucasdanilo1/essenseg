package sistema.essenseg.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.operadora.DadosListagemOperadora;
import sistema.essenseg.dto.operadora.DadosOperadoraDTO;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.repository.OperadoraRepository;

import java.util.List;

@Service
public class OperadoraService {

    @Autowired
    OperadoraRepository repository;

    public List<DadosListagemOperadora> listar() {
        return repository.findAll().stream().map(DadosListagemOperadora::new).toList();
    }

    public String cadastrar(DadosOperadoraDTO dados){
        if(repository.existsByNome(dados.nome())){
            throw new DataIntegrityViolationException("Operadora já cadastrada");
        }
        Operadora operadora = new Operadora(dados);
        repository.save(operadora);

        ObjectMapper objectMapper = new ObjectMapper();

        String json;

        try {
            json = objectMapper.writeValueAsString(operadora.getNome());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

            return json;
    }

    public DadosOperadoraDTO operadora(Long id) {
        return new DadosOperadoraDTO(repository.getReferenceById(id));
    }
}