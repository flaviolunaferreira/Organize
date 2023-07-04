package the.coyote.usuarios.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import the.coyote.usuarios.uteis.PermissoesEnum;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PermissoesEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermissao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarioEntity;
    
    private PermissoesEnum permissoesEnum;

    public PermissoesEntity(UsuarioEntity usuarioEntity, PermissoesEnum permissoesEnum)
    {
        this.usuarioEntity = usuarioEntity;
        this.permissoesEnum = permissoesEnum;
    }

}
