package the.coyote.usuarios.dto.permissoes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import the.coyote.usuarios.entities.PermissoesEntity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PermissoesDtoResponse {
    
    private Long idPermissao;
    private String usuario;
    private String permissoesEnum;

    public PermissoesDtoResponse(PermissoesEntity permissoes) {
        this.setIdPermissao(permissoes.getIdPermissao());
        this.setUsuario(permissoes.getUsuarioEntity().getNome());
        this.setPermissoesEnum(permissoes.getPermissoesEnum().getDescricao());
    }

}
