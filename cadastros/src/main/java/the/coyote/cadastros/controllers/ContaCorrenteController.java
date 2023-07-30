package the.coyote.cadastros.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import the.coyote.cadastros.dto.ContaCorrente.ContaCorrenteDtoRequest;
import the.coyote.cadastros.dto.ContaCorrente.ContaCorrenteDtoResponse;
import the.coyote.cadastros.service.ContaCorrenteService;

@RestController
@RequestMapping("api/v1/conta-corrente")
public class ContaCorrenteController {

    private final ContaCorrenteService contaCorrenteService;

    public ContaCorrenteController(ContaCorrenteService contaCorrenteService) {
        this.contaCorrenteService = contaCorrenteService;
    }

    @PostMapping("/")
    public ResponseEntity<ContaCorrenteDtoResponse> salvarContaCorrente(@RequestBody ContaCorrenteDtoRequest contaCorreteDtoRequest) {
        return ResponseEntity.ok().body(contaCorrenteService.salvarContaCorrente(contaCorreteDtoRequest));
    }

    @GetMapping("/")
    public ResponseEntity<List<ContaCorrenteDtoResponse>> ListarTodasContasCorrentes() {
        return ResponseEntity.ok().body(contaCorrenteService.ListarTodasContasCorrentes());
    } 

    @GetMapping("/{codigo}")
    public ResponseEntity<ContaCorrenteDtoResponse> procurarPorCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok().body(contaCorrenteService.procurarPorCodigo(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ContaCorrenteDtoResponse> alterarContaCorrente(@PathVariable Long codigo, @RequestBody ContaCorrenteDtoRequest contaCorrente) {
        return ResponseEntity.ok().body(contaCorrenteService.alterarContaCorrente(codigo, contaCorrente));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<ContaCorrenteDtoResponse> apagarContaCorrente(@PathVariable Long codigo) {
        return ResponseEntity.ok().body(contaCorrenteService.apagarContaCorrente(codigo));
    }
}
