package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.operadoraDTO.DadosOperadoraDTO;
import sistema.essenseg.service.OperadoraService;

@RestController
@RequestMapping("operadora")
public class OperadoraController {

    @Autowired
    OperadoraService service;

    @GetMapping("cadastro")
    public ResponseEntity<?> formulario() {
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<String> cadastro(@Valid @RequestBody DadosOperadoraDTO dados){
        return service.cadastrar(dados);
    }

}