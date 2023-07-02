package the.coyote.usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.usuarios.dto.usuarios.UsuariosDtoRequest;
import the.coyote.usuarios.dto.usuarios.UsuariosDtoResponse;
import the.coyote.usuarios.entities.UsuarioEntity;

@Service
public interface UsuariosService {
 
    List<UsuariosDtoResponse> listarTodosUsuarios(int pagina, int itens);

    UsuariosDtoResponse salvarNovoUsuario(UsuariosDtoRequest usuariosDtoRequest);

    Boolean validarUsuario(String usuario, String senha);

    UsuarioEntity buscarUsuarioPorId(Long usuario);

}
