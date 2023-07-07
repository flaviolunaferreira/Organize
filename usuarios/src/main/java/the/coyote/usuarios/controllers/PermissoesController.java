package the.coyote.usuarios.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import the.coyote.usuarios.dto.permissoes.PermissoesDtoRequest;
import the.coyote.usuarios.dto.permissoes.PermissoesDtoResponse;
import the.coyote.usuarios.service.PermissoesService;

@RestController
@RequestMapping("api/v1/permissao")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class PermissoesController {

    private final PermissoesService permissoesService;


    public PermissoesController(PermissoesService permissoesService) {
        this.permissoesService = permissoesService;
    }

    @PostMapping("/")
    public ResponseEntity<PermissoesDtoResponse> salvarNovaPermissao(
            @RequestBody @Validated PermissoesDtoRequest permissaoDtoRequest) {
        PermissoesDtoResponse resultado = permissoesService.salvarNovaPermissao(permissaoDtoRequest);
        return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("/")
    public ResponseEntity<List<PermissoesDtoResponse>> listarTodasPermissoes() {
        List<PermissoesDtoResponse> resultado = permissoesService.listarTodasPermissoes();
        return ResponseEntity.ok().body(resultado);
    }

}
