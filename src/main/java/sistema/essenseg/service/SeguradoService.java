package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.segurado.DadosListagemSegurado;
import sistema.essenseg.dto.segurado.FiltrosSeguradoDTO;
import sistema.essenseg.model.segurado.Segmentacao;
import sistema.essenseg.repository.SeguradoRepository;

@Service
public class SeguradoService {

    @Autowired
    SeguradoRepository repository;

    public Page<DadosListagemSegurado> listar(Pageable page){
        return repository.findAll(page).map(DadosListagemSegurado::new);
    }

    public Page<DadosListagemSegurado> listarFiltrados(FiltrosSeguradoDTO filtros, Pageable page) {
        Segmentacao segmentacao = null;
        if(filtros.segmentacao() != null){
            segmentacao = Segmentacao.valueOf(filtros.segmentacao());
        }
        return repository.findAll(filtros, page, segmentacao).map(DadosListagemSegurado::new);
    }

    public Long totalSegurados() {
        return repository.count();
    }

    public void inativarAtivar(Long id) {
        var segurado = repository.getReferenceById(id);
        segurado.setAtivo(!segurado.isAtivo());
        repository.save(segurado);
    }
}
