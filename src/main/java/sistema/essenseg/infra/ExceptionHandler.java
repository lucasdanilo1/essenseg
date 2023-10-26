package sistema.essenseg.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sistema.essenseg.dto.exceptionHandlerDTO.DadosErroValidacao;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> error404(){
        return ResponseEntity.notFound().build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> error400(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacao::new).toList());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NomeObjetoJaExistenteException.class)
    public ResponseEntity<?> NomeObjetoJaExistente(NomeObjetoJaExistenteException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ClienteJaCadastradoException.class)
    public ResponseEntity<?> ClienteJaCadastrado(ClienteJaCadastradoException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CpfObrigatorioException.class)
    public ResponseEntity<?> CpfObrigatorio(CpfObrigatorioException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CnpjObrigatorioException.class)
    public ResponseEntity<?> CnpjObrigatorio(CpfObrigatorioException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
