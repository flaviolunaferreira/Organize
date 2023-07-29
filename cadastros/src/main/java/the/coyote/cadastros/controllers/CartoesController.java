package the.coyote.cadastros.controllers;

import the.coyote.cadastros.dto.cartoes.CartoesDtoResponse;
import the.coyote.cadastros.dto.cartoes.CartoesDtoRequest;
import the.coyote.cadastros.service.CartoesService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartoes")
public class CartoesController {

    private final CartoesService cartoesService;

    public CartoesController(CartoesService cartoesService) {
        this.cartoesService = cartoesService;
    }

    @GetMapping()
    public ResponseEntity<List<CartoesDtoResponse>> listarTodos() {
        return ResponseEntity.ok().body(cartoesService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartoesDtoResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(cartoesService.buscarPorId(id));
    }

    @PostMapping("/")
    public ResponseEntity<CartoesDtoResponse> salvarCartao(@RequestBody CartoesDtoRequest cartao) {
        return ResponseEntity.ok().body(cartoesService.salvarCartao(cartao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartoesDtoResponse> update(@PathVariable Long id, @RequestBody CartoesDtoRequest cartoes) {
        return ResponseEntity.ok().body(cartoesService.alterarCartao(id, cartoes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        cartoesService.apagarCartao(id);
        return ResponseEntity.ok().build();
    }
}
