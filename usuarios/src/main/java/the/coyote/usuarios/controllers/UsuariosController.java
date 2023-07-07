package the.coyote.usuarios.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import the.coyote.usuarios.dto.usuarios.UsuariosDtoRequest;
import the.coyote.usuarios.dto.usuarios.UsuariosDtoResponse;
import the.coyote.usuarios.service.UsuariosService;

/**
 * TheCoyote
 */
@RestController
@RequestMapping("/api/v1/usuarios")
// @PreAuthorize("hasRole('ADMINISTRADOR')")
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping("/usuario")
    public ResponseEntity<UsuariosDtoResponse> salvarNovoUsuario(
            @RequestBody @Validated UsuariosDtoRequest usuariosDtoRequest) {
        UsuariosDtoResponse resultado = usuariosService.salvarNovoUsuario(usuariosDtoRequest);
        return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("/pagina/{pagina}/itens/{itens}")
    public ResponseEntity<List<UsuariosDtoResponse>> listarTodosUsuarios(@PathVariable int pagina,
                                                                        @PathVariable int itens) {
        List<UsuariosDtoResponse> resultado = usuariosService.listarTodosUsuarios(pagina, itens);
        return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> validarUsuario(@RequestParam String usuario,
                                                  @RequestParam String senha) {

        Boolean resultado = usuariosService.validarUsuario(usuario, senha);

        HttpStatus status = (resultado) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return  ResponseEntity.status(status).body(resultado);

    }

}