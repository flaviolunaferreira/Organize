package the.coyote.usuarios.dto.usuarios;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import the.coyote.usuarios.entities.UsuarioEntity;
import the.coyote.usuarios.uteis.Cpf;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDtoRequest {

    @NonNull
    @NotBlank
    private String nome;

    @Email
    private String email;

    @NonNull
    @NotBlank
    private String senha;

    @CPF
    private String cpf;

    public UsuarioEntity novoUsuario() {
        String CPF = new Cpf().formataCpf(cpf);
        return new UsuarioEntity(nome, email, senha, CPF);
    }
}
