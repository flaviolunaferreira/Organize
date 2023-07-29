package the.coyote.cadastros.service;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.cadastros.dto.ContaCorrente.ContaCorrenteDtoRequest;
import the.coyote.cadastros.dto.ContaCorrente.ContaCorrenteDtoResponse;

@Service
public interface ContaCorrenteService {

    ContaCorrenteDtoResponse salvarContaCorrente(ContaCorrenteDtoRequest contaCorreteDtoRequest);

    List<ContaCorrenteDtoResponse> ListarTodasContasCorrentes();

    ContaCorrenteDtoResponse procurarPorCodigo(Long codigo);

    ContaCorrenteDtoResponse alterarContaCorrente(Long codigo, ContaCorrenteDtoRequest contaCorrente);

    ContaCorrenteDtoResponse apagarContaCorrente(Long codigo);

}
