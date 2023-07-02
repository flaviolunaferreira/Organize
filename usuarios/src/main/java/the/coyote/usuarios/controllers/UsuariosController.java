package the.coyote.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import io.swagger.annotations.ApiOperation;
import the.coyote.usuarios.dto.usuarios.UsuariosDtoRequest;
import the.coyote.usuarios.dto.usuarios.UsuariosDtoResponse;
import the.coyote.usuarios.service.UsuariosService;

/**
 * TheCoyote
 */
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @ApiOperation(value = "Cadastra um novo Usuário", notes = "Cadastra um novo usuário no banco de dados.")
    @PostMapping("/usuario")
    public ResponseEntity<UsuariosDtoResponse> salvarNovoUsuario(
            @RequestBody @Validated UsuariosDtoRequest usuariosDtoRequest) {
        UsuariosDtoResponse resultado = usuariosService.salvarNovoUsuario(usuariosDtoRequest);
        return ResponseEntity.ok().body(resultado);
    }

    @ApiOperation(value = "Lista todos os usuário", notes = "Lista todos os usuários cadastrados.")
    @GetMapping("/pagina/{pagina}/itens/{itens}")
    public ResponseEntity<List<UsuariosDtoResponse>> listarTodosUsuarios(@PathVariable int pagina,
                                                                        @PathVariable int itens) {
        List<UsuariosDtoResponse> resultado = usuariosService.listarTodosUsuarios(pagina, itens);
        return ResponseEntity.ok().body(resultado);
    }

    /**
     * Atenção... na vida real as informações do usuário devem vir atravéz do body encriptografado...
     * evitando interceptação de dados mas enfim....
     * @param usuario
     * @param senha
     * @return boolean
     */
    @ApiOperation(value = "Valida informações de login", notes = "Valida informações de login de um usuário já cadastrado")
    @GetMapping("/login")
    public ResponseEntity<Boolean> validarUsuario(@RequestParam String usuario,
                                                  @RequestParam String senha) {
        // atribuindo responsabilidade para outra classe
        Boolean resultado = usuariosService.validarUsuario(usuario, senha);

        // montando a responsta
        HttpStatus status = (resultado) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return  ResponseEntity.status(status).body(resultado);

    }

}