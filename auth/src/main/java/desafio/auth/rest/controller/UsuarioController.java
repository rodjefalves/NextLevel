package desafio.auth.rest.controller;

import desafio.auth.entity.Usuario;
import desafio.auth.rest.dto.CredenciaisDTO;
import desafio.auth.rest.dto.TokenDTO;
import desafio.auth.security.JwtService;
import desafio.auth.service.exception.SenhaInvalidaException;
import desafio.auth.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final UsuarioServiceImpl usuarioService;

    @Autowired
    private final PasswordEncoder encoder;

//    @PostMapping("/api/usuarios")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Usuario salvar(@RequestBody Usuario dto) {
//        String senhaCriptografada = encoder.encode(dto.getSenha());
//        dto.setSenha(senhaCriptografada);
//        return usuarioService.salvar(dto);
//    }

    @GetMapping("/api/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvar() {
        String senhaCriptografada = encoder.encode("ironman");
        return senhaCriptografada;
    }

    @PostMapping("/api/usuarios/auth")
    public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciais){
        try{
            Usuario usuario = Usuario.builder()
                    .login(credenciais.getLogin())
                    .senha(credenciais.getSenha()).build();
            UserDetails usuarioAutenticado = usuarioService.autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new TokenDTO(usuario.getLogin(), token);
        } catch (UsernameNotFoundException | SenhaInvalidaException e ){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

}