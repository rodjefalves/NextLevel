package desafio.api.rest.controller;

import desafio.api.entity.Usuario;
import desafio.api.rest.dto.CredenciaisDTO;
import desafio.api.rest.dto.TokenDTO;
import desafio.api.security.JwtService;
import desafio.api.exception.SenhaInvalidaException;
import desafio.api.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final UsuarioServiceImpl usuarioService;

    @CrossOrigin
    @PostMapping("/autenticar")
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