package the.coyote.cadastros.service;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.cadastros.dto.cartoes.CartoesDtoResponse;
import the.coyote.cadastros.dto.cartoes.CartoesDtoRequest;

@Service
public interface CartoesService {

    List<CartoesDtoResponse> listarTodos();

    CartoesDtoResponse buscarPorId(Integer id);

    CartoesDtoResponse salvarCartao(CartoesDtoRequest cartao);

    CartoesDtoResponse alterarCartao(Long id, CartoesDtoRequest cartoes);

    void apagarCartao(Integer id);

}
