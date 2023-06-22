package the.coyote.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("api/v1/permissao")
public class PermissoesController {
    
    private final PermissaoService permissaoService;

    @Autowired
    public PermissaoControle(PermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }


    @ApiOperation(value = "Cadastra uma Nova Permissão", notes = "Cadastra uma nova Permissão de acesso." +
            "As Opções autorizadas são: ELEITOR e ADMINISTRADOR")
    @PostMapping("/")
    public ResponseEntity<PermissaoDtoResposta> salvarNovaPermissao(@RequestBody
                                                                    @Validated
                                                                    PermissaoDtoRequest permissaoDtoRequest) {
        PermissaoDtoResposta resultado = permissaoService.salvarNovaPermissao(permissaoDtoRequest);
        return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("/")
    public ResponseEntity<List<PermissaoDtoResposta>> listarTodasPermissoes() {
        List<PermissaoDtoResposta> resultado = permissaoService.listarTodasPermissoes();
        return ResponseEntity.ok().body(resultado);
    }

}
