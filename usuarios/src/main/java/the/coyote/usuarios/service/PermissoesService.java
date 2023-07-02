package the.coyote.usuarios.service;

import java.util.List;

import the.coyote.usuarios.dto.permissoes.PermissoesDtoRequest;
import the.coyote.usuarios.dto.permissoes.PermissoesDtoResponse;

public interface PermissoesService {

    PermissoesDtoResponse salvarNovaPermissao(PermissoesDtoRequest permissaoDtoRequest);

    List<PermissoesDtoResponse> listarTodasPermissoes();
    
}
