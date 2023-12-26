package sistema.essenseg.service;

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

    public Operadora cadastrar(DadosOperadoraDTO dados){
        if(repository.existsByNome(dados.nome())){
            throw new DataIntegrityViolationException("Operadora já cadastrada");
        }
            Operadora operadora = new Operadora(dados);
            repository.save(operadora);
            return operadora;
    }
}