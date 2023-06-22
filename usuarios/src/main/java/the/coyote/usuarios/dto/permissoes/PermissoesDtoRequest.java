package the.coyote.usuarios.dto.permissoes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import the.coyote.usuarios.entities.PermissoesEntity;
import the.coyote.usuarios.entities.UsuarioEntity;
import the.coyote.usuarios.repository.UsuarioRepository;
import the.coyote.usuarios.uteis.PermissoesEnum;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissoesDtoRequest {
    
    private Long usuario;
    private PermissoesEnum permissao;

    public PermissoesEntity novaPermissao(UsuarioRepository usuarioRepositorio) {
        UsuarioEntity usuarioEntity = usuarioRepositorio.findById(usuario).get();
        return new PermissoesEntity(usuarioEntity, permissao);
    }
    
}
