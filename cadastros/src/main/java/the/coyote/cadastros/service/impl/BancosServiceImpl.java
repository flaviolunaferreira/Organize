package the.coyote.cadastros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the.coyote.cadastros.dto.bancos.BancosDtoRequest;
import the.coyote.cadastros.dto.bancos.BancosDtoResponse;
import the.coyote.cadastros.repository.BancosRepository;
import the.coyote.cadastros.service.BancosService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BancosServiceImpl implements BancosService{

    @Autowired
    private final BancosRepository bancosRepository;

    public BancosServiceImpl(BancosRepository bancosRepository) {
        this.bancosRepository = bancosRepository;
    }

    @Override
    public BancosDtoResponse salvarNovoBanco(BancosDtoRequest bancosDtoRequest) {
        
        throw new UnsupportedOperationException("Unimplemented method 'salvarNovoBanco'");
    }
    

    @Override
    public List<BancosDtoResponse> listarTodosOsBancos() {
        return bancosRepository.findAll().stream().map(BancosDtoResponse::new).collect(Collectors.toList());
    }

    @Override
    public BancosDtoResponse buscarBancoPorNome(String nome) {

        throw new UnsupportedOperationException("Unimplemented method 'buscarBancoPorNome'");
    }

    @Override
    public BancosDtoResponse buscarBancoPorCodigo(Integer codigo) {

        throw new UnsupportedOperationException("Unimplemented method 'buscarBancoPorCodigo'");
    }

    @Override
    public BancosDtoResponse alterarBanco(Integer codigo, BancosDtoRequest bancosDtoRequest) {

        throw new UnsupportedOperationException("Unimplemented method 'alterarBanco'");
    }

    @Override
    public void apagarBanco(Integer codigo) {

        throw new UnsupportedOperationException("Unimplemented method 'apagarBanco'");
    }


}