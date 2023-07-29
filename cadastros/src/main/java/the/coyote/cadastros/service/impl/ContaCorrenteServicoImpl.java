package the.coyote.cadastros.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.cadastros.dto.ContaCorrente.ContaCorrenteDtoRequest;
import the.coyote.cadastros.dto.ContaCorrente.ContaCorrenteDtoResponse;
import the.coyote.cadastros.service.ContaCorrenteService;

@Service
public class ContaCorrenteServicoImpl implements ContaCorrenteService {

    @Override
    public ContaCorrenteDtoResponse salvarContaCorrente(ContaCorrenteDtoRequest contaCorreteDtoRequest) {        // 
        throw new UnsupportedOperationException("Unimplemented method 'salvarContaCorrente'");
    }

    @Override
    public List<ContaCorrenteDtoResponse> ListarTodasContasCorrentes() {
        throw new UnsupportedOperationException("Unimplemented method 'ListarTodasContasCorrentes'");
    }

    @Override
    public ContaCorrenteDtoResponse procurarPorCodigo(Long codigo) {
        throw new UnsupportedOperationException("Unimplemented method 'procurarPorCodigo'");
    }

    @Override
    public ContaCorrenteDtoResponse alterarContaCorrente(Long codigo, ContaCorrenteDtoRequest contaCorrente) {
        throw new UnsupportedOperationException("Unimplemented method 'alterarContaCorrente'");
    }

    @Override
    public ContaCorrenteDtoResponse apagarContaCorrente(Long codigo) {
        throw new UnsupportedOperationException("Unimplemented method 'apagarContaCorrente'");
    }
    
}
