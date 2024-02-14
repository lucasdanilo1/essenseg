package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sistema.essenseg.dto.anexo.DadosAnexoDTO;
import sistema.essenseg.service.AnexoService;

import java.util.List;

@RestController
@RequestMapping("anexo")
public class AnexoController {

    @Autowired
    AnexoService anexoService;

    @Transactional
    @PutMapping("/segurado/{seguradoId}")
    public ResponseEntity<?> uploadAnexo(@RequestParam("file") List<MultipartFile> listaDeAnexos, @PathVariable Long seguradoId){
        anexoService.uploadDeAnexos(listaDeAnexos, seguradoId);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @GetMapping("/segurado/{seguradoId}/anexos")
    public ResponseEntity<List<DadosAnexoDTO>> listaAnexosPorSegurado(@PathVariable Long seguradoId){
        return ResponseEntity.ok().body(anexoService.listaAnexosPorSegurado(seguradoId));
    }

    @GetMapping("/{anexoId}")
    public ResponseEntity<Resource> downloadAnexos(@PathVariable Long anexoId)  {
        var docData = anexoService.downloadAnexos(anexoId);
        return ResponseEntity.ok()
                .headers(docData.getHeaders())
                .contentLength(docData.getContentLength())
                .body(docData.getResource());
    }
}
