package the.coyote.cadastros.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import the.coyote.cadastros.dto.bancos.BancosDtoRequest;
import the.coyote.cadastros.dto.bancos.BancosDtoResponse;
import the.coyote.cadastros.service.BancosService;

@RestController
@RequestMapping("api/v1/bancoscontroller")
public class BancosController {

    private final BancosService bancosService;

    public BancosController(BancosService bancosService) {
		this.bancosService = bancosService;
	}

	@PostMapping("/")
    public ResponseEntity<BancosDtoResponse> salvaNovoBanco(@RequestBody @Validated BancosDtoRequest bancosDtoRequest) {
        return ResponseEntity.ok().body(bancosService.salvarNovoBanco(bancosDtoRequest));
    }

    @GetMapping("/")
    public ResponseEntity<List<BancosDtoResponse>> listarTodosOsBancos() {
        return ResponseEntity.ok().body(bancosService.listarTodosOsBancos());
    }
    
    @GetMapping("/nome/{nome}")
    public ResponseEntity<BancosDtoResponse> buscarBancoPorNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(bancosService.buscarBancoPorNome(nome));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<BancosDtoResponse> buscarBancoPorCodigo(@PathVariable Integer codigo) {
        return ResponseEntity.ok().body(bancosService.buscarBancoPorCodigo(codigo));
    }

    @PutMapping("/codigo/{codigo}")
    public ResponseEntity<BancosDtoResponse> alterarBanco(@PathVariable Integer codigo, BancosDtoRequest bancosDtoRequest) {
        return ResponseEntity.ok().body(bancosService.alterarBanco(codigo, bancosDtoRequest));
    }

    public ResponseEntity<BancosDtoResponse> apagarBanco(@PathVariable Integer codigo) {
        bancosService.apagarBanco(codigo);
        return ResponseEntity.ok().build();
    }

}
