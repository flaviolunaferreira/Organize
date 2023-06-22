package the.coyote.usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
 
    List<UsuarioDtoResposta> listarTodosUsuarios(int pagina, int itens);

    UsuarioDtoResposta salvarNovoUsuario(UsuarioDtoRequisicao usuarioDtoRequisicao);

    Boolean validarUsuario(String usuario, String senha);

    UsuarioEntidade buscarUsuarioPorId(Long usuario) throws NaoEncontrado;

}
