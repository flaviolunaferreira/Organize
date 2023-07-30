package the.coyote.cadastros.service;

import java.util.List;

import the.coyote.cadastros.dto.subContasCaixa.SubContasCaixaDtoRequest;
import the.coyote.cadastros.dto.subContasCaixa.SubContasCaixadtoResponse;

public interface SubContasCaixaService {

    List<SubContasCaixadtoResponse> listarTodos();

    SubContasCaixadtoResponse salvarSubContaCaixa(SubContasCaixaDtoRequest subContasCaixaDtoResquest);

    SubContasCaixadtoResponse atualizarSubContaCaixa(SubContasCaixaDtoRequest subContasCaixaDtoResquest, Integer id);

    void apagarSubContaCaixa(Integer id);

    SubContasCaixadtoResponse procurarSubContaCaixaPeloId(Integer id);

}
