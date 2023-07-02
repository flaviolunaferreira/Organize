package the.coyote.usuarios.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import the.coyote.usuarios.dto.usuarios.UsuariosDtoRequest;
import the.coyote.usuarios.dto.usuarios.UsuariosDtoResponse;
import the.coyote.usuarios.entities.UsuarioEntity;
import the.coyote.usuarios.exceptions.DuplicateValue;
import the.coyote.usuarios.repository.UsuarioRepository;
import the.coyote.usuarios.service.PermissoesService;
import the.coyote.usuarios.service.UsuariosService;
import the.coyote.usuarios.uteis.Cpf;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuariosService {

    private final UsuarioRepository usuarioRepositorio;
    private final PermissoesService permissaoService;

    private BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    private final Cpf cpf;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepositorio, PermissoesService permissaoService, Cpf cpf) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.permissaoService = permissaoService;
        this.cpf = cpf;
    }


    /**
     * @param usuarioDtoRequisicao
     * @return
     */
    @Override
    public UsuariosDtoResponse salvarNovoUsuario(UsuariosDtoRequest usuarioDtoRequisicao) throws DuplicateValue {
        // encriptando a senha do usuário.
        usuarioDtoRequisicao.setSenha(encoder().encode(usuarioDtoRequisicao.getSenha()));

        UsuarioEntity procurarPorCpf = usuarioRepositorio.findUsuarioByCpf(
                cpf.formataCpf(usuarioDtoRequisicao.getCpf()));
        if (procurarPorCpf == null)
            return new UsuarioDtoResposta(usuarioRepositorio.save(usuarioDtoRequisicao.novoUsuario()));
        throw new ValorDuplicado("Sinto Muito... Cpf Já cadastrado!");
    }

    /**
     * @param usuario 
     * @param senha
     * @return
     */
    @Override
    public Boolean validarUsuario(String usuario, String senha) {
        // procurando o usuario pelo nome
        Optional<UsuarioEntidade> opUsuario = usuarioRepositorio.findByNome(usuario);
        // se não existir já retorna falso
        if (opUsuario.isEmpty()) return false;

        // se o usuario existir vou pegar o cadastro dele
        UsuarioEntidade usuarioEntidade = opUsuario.get();

        // agora validando a senha
        return encoder().matches(senha, usuarioEntidade.getSenha());

    }


    @Override
    public UsuarioEntidade buscarUsuarioPorId(Long usuario) throws NaoEncontrado {
        return usuarioRepositorio.findById(usuario)
                .orElseThrow(() ->  new NaoEncontrado("Desculpe, mas não encontrei o usuário com o id: " + usuario));
    }


    /**
     * @return
     */
    @Override
    public List<UsuarioDtoResposta> listarTodosUsuarios(int pagina, int itens) {

        if(itens > 50) itens = 50;

        PageRequest page = PageRequest.of(pagina, itens);

        Page<UsuarioEntidade> lista = usuarioRepositorio.findAll(page);

        return lista.stream().map(UsuarioDtoResposta::new).collect(Collectors.toList());

    }

}