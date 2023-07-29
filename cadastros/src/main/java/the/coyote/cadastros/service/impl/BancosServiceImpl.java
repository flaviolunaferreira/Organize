package the.coyote.cadastros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the.coyote.cadastros.dto.bancos.BancosDtoRequest;
import the.coyote.cadastros.dto.bancos.BancosDtoResponse;
import the.coyote.cadastros.entity.BancosEntity;
import the.coyote.cadastros.exceptions.IntegratyViolation;
import the.coyote.cadastros.exceptions.NotFound;
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
        return new BancosDtoResponse(bancosRepository.save(bancosDtoRequest.newBanco()));        
    }
    

    @Override
    public List<BancosDtoResponse> listarTodosOsBancos() {
        return bancosRepository.findAll().stream().map(BancosDtoResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<BancosDtoResponse> buscarBancoPorNome(String nome) {
        return bancosRepository.findByNomeContainingIgnoreCase(nome).stream().map(BancosDtoResponse::new).collect(Collectors.toList());
    }

    @Override
    public BancosDtoResponse buscarBancoPorCodigo(Integer codigo) {
        return new BancosDtoResponse(findById(codigo));
    }

    @Override
    public BancosDtoResponse alterarBanco(Integer codigo, BancosDtoRequest bancosDtoRequest) {
        BancosEntity banco = findById(codigo);
        {
            banco.setNome(bancosDtoRequest.getNome());
        }
        return salvarNovoBanco(bancosDtoRequest);
    }

    @Override
    public void apagarBanco(Integer codigo) throws IntegratyViolation {
        BancosEntity banco = findById(codigo);
        try {
            bancosRepository.delete(banco);
        } catch (IntegratyViolation e) {
            throw new IntegratyViolation("Erro de integridade relacional -> Registro esta sendo usado em outra(s) tabela(s)...");
        }
    }

    private BancosEntity findById(Integer id) throws NotFound {
        return bancosRepository.findById(id).orElseThrow(() -> new NotFound("Sinto muito. Banco não encontrado com o código " + id));
    }
}
