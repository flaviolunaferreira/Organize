package the.coyote.cadastros.controllers;

import lombok.RequiredArgsConstructor;
import the.coyote.cadastros.dto.contasCaixa.ContasCaixaDtoRequest;
import the.coyote.cadastros.dto.contasCaixa.ContasCaixaDtoResponse;
import the.coyote.cadastros.service.ContasCaixaService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contascaixa")
public class ContasCaixaController {

    private final ContasCaixaService  contasCaixaService;

    public ContasCaixaController(ContasCaixaService contasCaixaService) {
        this.contasCaixaService = contasCaixaService;
    }

    @GetMapping()
    public ResponseEntity<List<ContasCaixaDtoResponse>> ListarTodasContas() {
        return ResponseEntity.ok().body(contasCaixaService.ListarTodasContas());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ContasCaixaDtoResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(contasCaixaService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<ContasCaixaDtoResponse> create(@RequestBody ContasCaixaDtoRequest ContasCaixaDtoRequest) {
        return ResponseEntity.ok().body(contasCaixaService.salvarNovaContaCaixa(ContasCaixaDtoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContasCaixaDtoResponse> update(@RequestBody ContasCaixaDtoRequest contasCaixaDtoRequest, @PathVariable Integer id) {
        return ResponseEntity.ok().body(contasCaixaService.atualizarContaCaixa(contasCaixaDtoRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        contasCaixaService.apagarContaCaixa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
