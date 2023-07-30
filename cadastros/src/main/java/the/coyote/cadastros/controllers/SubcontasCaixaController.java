package the.coyote.cadastros.controllers;

import the.coyote.cadastros.dto.subContasCaixa.SubContasCaixaDtoRequest;
import the.coyote.cadastros.dto.subContasCaixa.SubContasCaixadtoResponse;
import the.coyote.cadastros.service.SubContasCaixaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subcontascaixa")
public class SubcontasCaixaController {

    @Autowired
    private SubContasCaixaService subContasCaixaService;

    @GetMapping()
    public ResponseEntity<List<SubContasCaixadtoResponse>> listarTodas() {
        return ResponseEntity.ok().body(subContasCaixaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubContasCaixadtoResponse> procurarPeloId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(subContasCaixaService.procurarSubContaCaixaPeloId(id));
    }

    @PostMapping()
    public ResponseEntity<SubContasCaixadtoResponse> create(@RequestBody SubContasCaixaDtoRequest subContasCaixaDtoResquest) {
        return ResponseEntity.ok().body(subContasCaixaService.salvarSubContaCaixa(subContasCaixaDtoResquest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody SubContasCaixaDtoRequest subContasCaixaDtoResquest,@PathVariable Integer id) {
        return ResponseEntity.ok().body(subContasCaixaService.atualizarSubContaCaixa(subContasCaixaDtoResquest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        subContasCaixaService.apagarSubContaCaixa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
