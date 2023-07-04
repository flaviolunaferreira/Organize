package the.coyote.usuarios.service.impl;


import org.springframework.stereotype.Service;

import the.coyote.usuarios.dto.permissoes.PermissoesDtoRequest;
import the.coyote.usuarios.dto.permissoes.PermissoesDtoResponse;
import the.coyote.usuarios.entities.PermissoesEntity;
import the.coyote.usuarios.entities.UsuarioEntity;
import the.coyote.usuarios.exceptions.DuplicateValue;
import the.coyote.usuarios.exceptions.NotFound;
import the.coyote.usuarios.repository.PermissoesRepository;
import the.coyote.usuarios.repository.UsuarioRepository;
import the.coyote.usuarios.service.PermissoesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PermissaoServiceImpl implements PermissoesService {

    private final PermissoesRepository permissaoRepositorio;
    private final UsuarioRepository usuarioRepositorio;

    public PermissaoServiceImpl(PermissoesRepository permissaoRepositorio, UsuarioRepository usuarioRepositorio) {
        this.permissaoRepositorio = permissaoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public PermissoesDtoResponse salvarNovaPermissao(PermissoesDtoRequest permissaoDtoRequest) throws DuplicateValue {

        Optional<UsuarioEntity> usuarioEntidade = usuarioRepositorio.findById(permissaoDtoRequest.getUsuario());

        List<PermissoesEntity> seExiste = usuarioEntidade.get().getPermissoesEntity()
                .stream().filter(item -> item.getPermissoesEnum().getDescricao()
                .contentEquals(permissaoDtoRequest.getPermissao().getDescricao()))
                .collect(Collectors.toList());

        if (seExiste.isEmpty())
            return new PermissoesDtoResponse(
                    permissaoRepositorio.save(permissaoDtoRequest.novaPermissao(usuarioRepositorio))
            );
        throw new DuplicateValue("Sinto muito... já tenho uma permissão com esse nome para esse Usuário.");
    }

    public PermissoesEntity buscarPorId(Long permissao) throws NotFound {
         return permissaoRepositorio.findById(permissao)
            .orElseThrow(() ->  new NotFound("Desculpe, mas não encontrei a permissão com o id: " + permissao));
    }
    
    public List<PermissoesDtoResponse> listarTodasPermissoes() {
        List<PermissoesEntity> list = (List<PermissoesEntity>) permissaoRepositorio.findAll();
        return list.stream().map(PermissoesDtoResponse::new).collect(Collectors.toList());
    }
}
