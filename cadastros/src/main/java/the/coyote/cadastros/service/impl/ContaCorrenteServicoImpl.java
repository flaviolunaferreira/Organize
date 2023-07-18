package the.coyote.cadastros.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.cadastros.dto.ContaCorrente.ContaCorrenteDtoRequest;
import the.coyote.cadastros.dto.ContaCorrente.ContaCorrenteDtoResponse;
import the.coyote.cadastros.service.ContaCorrenteService;

@Service
public class ContaCorrenteServicoImpl implements ContaCorrenteService {

    @Override
    public ContaCorrenteDtoResponse salvarContaCorrente(ContaCorrenteDtoRequest contaCorreteDtoRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvarContaCorrente'");
    }

    @Override
    public List<ContaCorrenteDtoResponse> ListarTodasContasCorrentes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ListarTodasContasCorrentes'");
    }
    
}
