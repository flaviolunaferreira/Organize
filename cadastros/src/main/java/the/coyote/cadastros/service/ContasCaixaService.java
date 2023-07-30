package the.coyote.cadastros.service;

import java.util.List;

import the.coyote.cadastros.dto.contasCaixa.ContasCaixaDtoRequest;
import the.coyote.cadastros.dto.contasCaixa.ContasCaixaDtoResponse;

public interface ContasCaixaService {

    List<ContasCaixaDtoResponse> ListarTodasContas();

    ContasCaixaDtoResponse findById(Integer id);

    ContasCaixaDtoResponse salvarNovaContaCaixa(ContasCaixaDtoRequest contasCaixaDtoRequest);

    ContasCaixaDtoResponse atualizarContaCaixa(ContasCaixaDtoRequest contasCaixaDtoRequest, Integer id);

    void apagarContaCaixa(Integer id);

}
