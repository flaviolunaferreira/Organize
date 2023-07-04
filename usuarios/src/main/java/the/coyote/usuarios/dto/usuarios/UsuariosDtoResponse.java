package the.coyote.usuarios.dto.usuarios;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import the.coyote.usuarios.entities.PermissoesEntity;
import the.coyote.usuarios.entities.UsuarioEntity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDtoResponse {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private List<PermissoesEntity> permissoes;

    private String criadoPor;
    private LocalDateTime criadoData;
    private String modificadoPor;
    private LocalDateTime modificadoData;

    public UsuariosDtoResponse(UsuarioEntity usuarioEntidade) {
        this.setId(usuarioEntidade.getIdUsuario());
        this.setNome(usuarioEntidade.getNome());
        this.setEmail(usuarioEntidade.getEmail());
        this.setCpf(usuarioEntidade.getCpf());
        this.setPermissoes(usuarioEntidade.getPermissoesEntity());
        this.setCriadoPor(usuarioEntidade.getCriadoPor());
        this.setCriadoData(usuarioEntidade.getCriadoData());
        this.setModificadoPor(usuarioEntidade.getModificadoPor());
        this.setModificadoData(usuarioEntidade.getModificadoData());

    }
    
}
