package the.coyote.cadastros.service;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.cadastros.dto.bancos.BancosDtoRequest;
import the.coyote.cadastros.dto.bancos.BancosDtoResponse;

@Service
public interface BancosService {

	BancosDtoResponse salvarNovoBanco(BancosDtoRequest bancosDtoRequest);

	List<BancosDtoResponse> listarTodosOsBancos();

	List<BancosDtoResponse> buscarBancoPorNome(String nome);

	BancosDtoResponse buscarBancoPorCodigo(Integer codigo);

	BancosDtoResponse alterarBanco(Integer codigo, BancosDtoRequest bancosDtoRequest);

	void apagarBanco(Integer codigo);

}
