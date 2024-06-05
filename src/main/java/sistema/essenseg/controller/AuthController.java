package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistema.essenseg.dto.auth.DadosAutenticacao;
import sistema.essenseg.dto.auth.DadosCadastroUsuario;
import sistema.essenseg.dto.auth.RespostaLoginDTO;
import sistema.essenseg.infra.security.TokenService;
import sistema.essenseg.model.Usuario;
import sistema.essenseg.repository.UsuarioRepository;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService service;

    @Transactional
    @PostMapping("login")
    public ResponseEntity<RespostaLoginDTO> login(@Valid @RequestBody DadosAutenticacao dados){
        var loginSenha = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var auth = this.manager.authenticate(loginSenha);

        var token = service.geradorToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new RespostaLoginDTO(token, dados.login()));
    }

    @Transactional
    @PostMapping("registrar")
    public ResponseEntity<?> registrar(@Valid @RequestBody DadosCadastroUsuario dados){
        if(repository.findByLogin(dados.login()) != null){
            ResponseEntity.badRequest().build();
        }
        String senhaEncriptada  = new BCryptPasswordEncoder().encode(dados.senha());
        Usuario usuario = new Usuario(dados.login(), senhaEncriptada, dados.role());
        repository.save(usuario);
        return ResponseEntity.ok().build();
    }

}
