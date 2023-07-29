package the.coyote.cadastros.controllers;

import lombok.RequiredArgsConstructor;
import the.coyote.cadastros.service.ContasCaixaService;

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
    public ResponseEntity<ContasCaixaDtoResponse> ListarTodasContas() {
        return ResponseEntity.ok().body(contasCaixaService.ListarTodasContas());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {

    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Dto dto) {

    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Dto dto) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

    }
}
