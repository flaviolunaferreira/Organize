package the.coyote.usuarios.dto.usuarios;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.NonNull;
import the.coyote.usuarios.entities.UsuarioEntity;
import the.coyote.usuarios.uteis.Cpf;

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
