package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.segurado.DadosListagemSegurado;
import sistema.essenseg.dto.segurado.FiltrosSeguradoDTO;
import sistema.essenseg.service.SeguradoService;

@RestController
@RequestMapping("segurado")
public class ListaSeguradosController {

    @Autowired
    SeguradoService service;

    @GetMapping("total-segurados")
    public ResponseEntity<Long> totalSegurados() {
        return ResponseEntity.ok().body(service.totalSegurados());
    }

    @DeleteMapping("inativar-ativar/{id}")
    public ResponseEntity<?> inativarAtivarSegurado(@PathVariable Long id){
        service.inativarAtivar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("lista")
    public ResponseEntity<Page<DadosListagemSegurado>> segurados(@PageableDefault(size = 100) Pageable page) {
        return ResponseEntity.ok().body(service.listar(page));
    }

    @Transactional
    @PostMapping("lista/filtrada")
    public ResponseEntity<Page<DadosListagemSegurado>> seguradosFiltrados(@RequestBody FiltrosSeguradoDTO filtros, @PageableDefault(size = 100) Pageable page) {
        return ResponseEntity.ok().body(service.listarFiltrados(filtros, page));
    }
}
