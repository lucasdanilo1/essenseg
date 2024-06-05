package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sistema.essenseg.dto.operadora.DadosListagemOperadora;
import sistema.essenseg.dto.operadora.DadosOperadoraDTO;
import sistema.essenseg.service.OperadoraService;

import java.util.List;

@RestController
@RequestMapping("operadora")
public class OperadoraController {

    @Autowired
    OperadoraService service;

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<String> cadastro(@Valid @RequestBody DadosOperadoraDTO dados){
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .replacePath("listagem/operadoras")
                .build().toUri()).body(service.cadastrar(dados));
    }

    @GetMapping("lista")
    public ResponseEntity<List<DadosListagemOperadora>> operadoras(){
        return ResponseEntity.ok().body(service.listar());
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosOperadoraDTO> operadora(@PathVariable Long id){
        return ResponseEntity.ok().body(service.operadora(id));
    }

}