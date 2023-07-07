package the.coyote.cadastros.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
}
